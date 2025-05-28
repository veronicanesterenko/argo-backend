package com.website.argo.service;

import com.website.argo.dto.BrandCreateEditDto;
import com.website.argo.dto.BrandDto;
import com.website.argo.dto.CategoryCreateEditDto;
import com.website.argo.dto.CategoryDto;
import com.website.argo.entity.Brand;
import com.website.argo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    CategoryDto findById(Long id);
    void save(CategoryCreateEditDto categoryCreateEditDto);
    void update(Long id);
    void delete(Long id);
}
