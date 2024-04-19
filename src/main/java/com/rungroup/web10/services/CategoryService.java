package com.rungroup.web10.services;

import com.rungroup.web10.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(Long categoryId);

    CategoryDto createCategory(CategoryDto categoryDto);

    void deleteCategory(Long categoryId);
}
