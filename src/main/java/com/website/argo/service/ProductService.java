package com.website.argo.service;

import com.website.argo.dto.ProductDto;
import com.website.argo.entity.Product;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<ProductDto> findAll(String category, PageRequest pageRequest);
    ProductDto findById(Long productId);
    void save(Product product);
    void delete(Long id);
}
