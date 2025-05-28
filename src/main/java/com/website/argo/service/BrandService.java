package com.website.argo.service;

import com.website.argo.dto.BrandCreateEditDto;
import com.website.argo.dto.BrandDto;
import com.website.argo.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    BrandDto findById(Long id);
    void save(BrandCreateEditDto brandCreateEditDto);
    void update(Long id);
    void delete(Long brandId);
}
