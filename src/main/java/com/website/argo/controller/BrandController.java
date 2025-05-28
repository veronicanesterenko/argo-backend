package com.website.argo.controller;

import com.website.argo.dto.BrandCreateEditDto;
import com.website.argo.dto.BrandDto;
import com.website.argo.mapper.BrandMapper;
import com.website.argo.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public BrandDto getBrand(@PathVariable Long id) {
        return brandService.findById(id);
    }

    @PostMapping
    public void createBrand(@RequestBody BrandCreateEditDto brandCreateEditDto) {
        brandService.save(brandCreateEditDto);
    }

    @PatchMapping("/{id}")
    public void updateBrand(@PathVariable Long id) {
        brandService.update(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable Long id) {
        brandService.delete(id);
    }
}
