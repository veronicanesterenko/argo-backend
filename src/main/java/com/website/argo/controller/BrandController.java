package com.website.argo.controller;

import com.website.argo.dto.BrandDto;
import com.website.argo.mapper.BrandMapper;
import com.website.argo.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandController {

    private final BrandService brandService;
    private final BrandMapper brandMapper;

    @GetMapping
    public List<BrandDto> getAllBrand() {
        return brandService.findAll()
                .stream().map(brandMapper::toBrandDto).toList();
    }
}
