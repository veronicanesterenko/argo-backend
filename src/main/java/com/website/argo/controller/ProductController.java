package com.website.argo.controller;

import com.website.argo.dto.ProductCreatedEditDto;
import com.website.argo.dto.ProductDto;
import com.website.argo.entity.Product;
import com.website.argo.mapper.ProductMapper;
import com.website.argo.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.findAll()
                .stream()
                .map(productMapper::toProductDto).toList();
    }

    @GetMapping("/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
      Product product = productService.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product with id = " + productId + " not found"));
      return productMapper.toProductDto(product);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductCreatedEditDto productCreatedEditDto) {
        Product product = productMapper.toProduct(productCreatedEditDto);
        productService.save(product);
    }


}
