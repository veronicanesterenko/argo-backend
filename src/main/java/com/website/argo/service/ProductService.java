package com.website.argo.service;

import com.website.argo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long productId);
    void save(Product product);
}
