package com.website.argo.mapper;

import com.website.argo.dto.BrandCreateEditDto;
import com.website.argo.dto.BrandDto;
import com.website.argo.entity.Brand;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDto toBrandDto(Brand brand);

    Brand toBrand(BrandCreateEditDto brandCreateEditDto);
}
