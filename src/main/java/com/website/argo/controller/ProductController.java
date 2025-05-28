package com.website.argo.controller;

import com.website.argo.dto.ProductCreatedEditDto;
import com.website.argo.dto.ProductDto;
import com.website.argo.entity.Product;
import com.website.argo.mapper.ProductMapper;
import com.website.argo.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping("/catalog")
    public List<ProductDto> getProductsByCategory(@RequestParam("category") String category,
                                                  @RequestParam(required = false, defaultValue = "0") int page,
                                                  @RequestParam(required = false, defaultValue = "10") int size) {
        return productService.findAll(category, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
      return productService.findById(id);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductCreatedEditDto productCreatedEditDto) {
        Product product = productMapper.toProduct(productCreatedEditDto);
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
