package com.website.argo.controller;

import com.website.argo.dto.ProductDto;
import com.website.argo.mapper.ProductMapper;
import com.website.argo.service.ProductService;
import com.website.argo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    //@Qualifier("dummyProductServiceImpl")
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.findAll()
                .stream()
                .map(product -> productMapper.mapToDto(product)).toList();

    }
}
