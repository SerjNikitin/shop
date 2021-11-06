package com.geekbrains.shop.service.impl;

import com.geekbrains.shop.domain.ProductReviewEntity;
import com.geekbrains.shop.dto.ProductReviewDto;
import com.geekbrains.shop.service.ConverterService;
import com.geekbrains.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConverterServiceImpl implements ConverterService {
    private final ModelMapper modelMapper;
    private final ProductService productService;


    @Override
    public ProductReviewDto convertReviewEntityToDto(ProductReviewEntity productReview) {
        ProductReviewDto map = modelMapper.map(productReview, ProductReviewDto.class);
        map.setProductId(productReview.getProductId().getId());
        return map;
    }

    @Override
    public ProductReviewEntity convertReviewDtoToEntity(ProductReviewDto productReviewDto) {
        ProductReviewEntity map = modelMapper.map(productReviewDto, ProductReviewEntity.class);
        map.setProductId(productService.getProductById(productReviewDto.getProductId()));
        return map;
    }
}
