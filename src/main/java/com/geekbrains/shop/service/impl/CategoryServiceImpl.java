package com.geekbrains.shop.service.impl;

import com.geekbrains.shop.domain.CategoryEntity;
import com.geekbrains.shop.dto.CategoryViewDto;
import com.geekbrains.shop.repository.CategoryRepository;
import com.geekbrains.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryEntity> findCategoryDto() {
        return categoryRepository.findAll();

    }

    @Override
    public void createCategory(CategoryEntity categoryEntity) {
        categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}