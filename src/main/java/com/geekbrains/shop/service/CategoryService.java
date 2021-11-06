package com.geekbrains.shop.service;

import com.geekbrains.shop.domain.CategoryEntity;
import com.geekbrains.shop.dto.CategoryViewDto;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> findCategoryDto();

    void createCategory(CategoryEntity categoryEntity);

    CategoryEntity findCategoryById(Long id);
}