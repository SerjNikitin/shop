package com.geekbrains.shop.controller;

import com.geekbrains.shop.dto.ProductReviewDto;
import com.geekbrains.shop.service.ProductReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.geekbrains.shop.domain.constant.RestControllerName.API_V1;
import static com.geekbrains.shop.domain.constant.RestControllerName.PRODUCT_REVIEW;

@RestController
@RequestMapping(API_V1+PRODUCT_REVIEW)
@RequiredArgsConstructor
public class ProductReviewController {
    private final ProductReviewService productReviewService;

    @PostMapping
    public ProductReviewDto saveReview(@RequestBody ProductReviewDto productReviewDto){
        return productReviewService.saveProductReview(productReviewDto);
    }
}
