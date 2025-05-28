package com.website.argo.controller;

import com.website.argo.dto.BrandCreateEditDto;
import com.website.argo.dto.CategoryCreateEditDto;
import com.website.argo.dto.CategoryDto;
import com.website.argo.mapper.CategoryMapper;
import com.website.argo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/V1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.findAll().stream().map(categoryMapper::toCategoryDto).toList();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public void createCategory(@RequestBody CategoryCreateEditDto categoryCreateEditDto) {
        categoryService.save(categoryCreateEditDto);
    }

    @PatchMapping("/{id}")
    public void updateCategory(@PathVariable Long id) {
        categoryService.update(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
