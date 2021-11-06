package com.geekbrains.shop.controller;

import com.geekbrains.shop.domain.CategoryEntity;
import com.geekbrains.shop.dto.CategoryViewDto;
import com.geekbrains.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.geekbrains.shop.domain.constant.RestControllerName.API_V1;
import static com.geekbrains.shop.domain.constant.RestControllerName.CATEGORY;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1 + CATEGORY)
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> getCategories() {
        return categoryService.findCategoryDto();
    }

    @RequestMapping(method = {POST,PUT})
    public int addCategory(@RequestBody CategoryEntity categoryEntity) {
        categoryService.createCategory(categoryEntity);
        return HttpStatus.OK.value();
    }
//    @GetMapping("/{id}")
//    public CategoryEntity getCategoryById(@PathVariable Long id) {
//        return categoryService.findCategoryById(id).get();
////
//    }
////
//    @PutMapping("/{id}")
//    public int updateCategory(@PathVariable Long id, @RequestBody String title) {
//        categoryService.updateCategory(id, title);
//        return HttpStatus.OK.value();
//    }
//
//    @DeleteMapping("/{id}")
//    public int deleteCategory(@PathVariable Long id) {
//        categoryService.deleteCategory(id);
//        return HttpStatus.OK.value();
//    }
}