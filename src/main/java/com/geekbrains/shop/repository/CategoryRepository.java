package com.geekbrains.shop.repository;

import com.geekbrains.shop.domain.CategoryEntity;
import com.geekbrains.shop.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
