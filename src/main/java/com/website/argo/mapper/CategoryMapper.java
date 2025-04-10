package com.website.argo.mapper;

import com.website.argo.dto.CategoryDto;
import com.website.argo.entity.Category;
import com.website.argo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "productDtoList", source = "productList", qualifiedByName = "productListToString")
    CategoryDto toCategoryDto(Category category);

    @Named("productListToString")
    default List<String> productListToString(List<Product> productList) {
        return productList.stream().map(Product::getName).toList();
    }
}
