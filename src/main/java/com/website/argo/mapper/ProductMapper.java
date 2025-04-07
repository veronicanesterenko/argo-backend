package com.website.argo.mapper;

import com.website.argo.dto.ProductDto;
import com.website.argo.entity.Brand;
import com.website.argo.entity.Category;
import com.website.argo.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public ProductDto mapToDto(Product product) {
        return ProductDto.builder().name(product.getName())
                .brand(product.getBrand().getName())
                .itemNumber(product.getItemNumber())
                .mainImage(product.getMainImage())
                .supplementsFacts(product.getSupplementFacts())
                .score(product.getScore())
                .shortDescription(product.getShortDescription())
                .fullDescription(product.getFullDescription())
                .categories(product.getCategoryList()
                        .stream()
                        .map(Category::getName)
                        .toList())
                .build();
    }

    public Product mapToProduct(ProductDto productDto) {
        return new Product();
    }
}
