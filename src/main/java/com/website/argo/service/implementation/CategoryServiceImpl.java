package com.website.argo.service.implementation;

import com.website.argo.dto.CategoryCreateEditDto;
import com.website.argo.dto.CategoryDto;
import com.website.argo.entity.Category;
import com.website.argo.mapper.CategoryMapper;
import com.website.argo.repository.CategoryRepository;
import com.website.argo.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category with id = " + id + " not found"));
        return categoryMapper.toCategoryDto(category);
    }

    @Transactional
    @Override
    public void save(CategoryCreateEditDto categoryCreateEditDto) {
        Category category = categoryMapper.toCategory(categoryCreateEditDto);
        categoryRepository.save(category);
    }

    @Transactional
    @Override
    public void update(Long id) {

    }

    @Transactional
    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category with id = " + id + " not found"));
        categoryRepository.delete(category);
    }
}
