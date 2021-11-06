package com.geekbrains.shop.repository;

import com.geekbrains.shop.domain.ProductReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReviewEntity, Long> {

}
