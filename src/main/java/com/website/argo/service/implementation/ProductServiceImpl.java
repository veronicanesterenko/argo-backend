package com.website.argo.service.implementation;

import com.website.argo.dto.ProductDto;
import com.website.argo.entity.Category;
import com.website.argo.mapper.ProductMapper;
import com.website.argo.repository.CategoryRepository;
import com.website.argo.service.ProductService;
import com.website.argo.entity.Product;
import com.website.argo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public List<Product> findAll() {
      return productRepository.findAll();
    }

    public List<ProductDto> findAll(String categoryName, PageRequest pageRequest) {
        Category category = categoryRepository.findByName(categoryName).orElseThrow(() ->
                new EntityNotFoundException("Category with name = " + categoryName + " not found"));
        return productRepository.findAllByCategoryList(category, pageRequest).stream()
                .map(productMapper::toProductDto).toList();
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    @Transactional
    public void save(Product product) { productRepository.save(product);}


}
