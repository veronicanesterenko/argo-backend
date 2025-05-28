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
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product with id = " + id + " not found"));
        return productMapper.toProductDto(product);

    }

    @Override
    @Transactional
    public void save(Product product) { productRepository.save(product);}

    @Override
    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
