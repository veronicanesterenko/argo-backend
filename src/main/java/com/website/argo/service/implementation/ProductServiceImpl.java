package com.website.argo.service.implementation;

import com.website.argo.service.ProductService;
import com.website.argo.entity.Product;
import com.website.argo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
      return productRepository.findAll();
    }
}
