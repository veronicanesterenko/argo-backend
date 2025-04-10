package com.website.argo.mapper;

import com.website.argo.dto.ProductCreatedEditDto;
import com.website.argo.dto.ProductDto;
import com.website.argo.entity.Brand;
import com.website.argo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        uses = {CategoryMapper.class, BrandMapper.class})

public interface ProductMapper {

    @Mappings({
        @Mapping(target = "brandName", source = "brand", qualifiedByName = "brandToString"),
        @Mapping(target = "categoryDtoList", source = "categoryList")
    })
    ProductDto toProductDto(Product product);

    @Named("brandToString")
    default String brandToString(Brand brand) {return brand.getName();}



    @Mapping(target = "brand", source = "brandId", qualifiedByName = "brandNameToBrand")
    Product toProduct(ProductCreatedEditDto productCreatedEditDto);


    @Named("brandNameToBrand")
    default Brand brandNameToBrand(Long id) {
        return Brand.builder().id(id).build();
    }

}
