package com.geekbrains.shop.service;

import com.geekbrains.shop.domain.ProductEntity;
import com.geekbrains.shop.domain.ProductReviewEntity;
import com.geekbrains.shop.dto.ProductBaseViewDto;
import com.geekbrains.shop.dto.ProductReviewDto;

public interface ConverterService {

    ProductReviewDto convertReviewEntityToDto(ProductReviewEntity productReview);

    ProductReviewEntity convertReviewDtoToEntity(ProductReviewDto productReviewDto);


}
