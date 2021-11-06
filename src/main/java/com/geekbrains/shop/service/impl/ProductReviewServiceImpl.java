package com.geekbrains.shop.service.impl;

import com.geekbrains.shop.domain.ProductReviewEntity;
import com.geekbrains.shop.dto.ProductReviewDto;
import com.geekbrains.shop.repository.ProductReviewRepository;
import com.geekbrains.shop.service.ConverterService;
import com.geekbrains.shop.service.ProductReviewService;
import com.geekbrains.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductReviewServiceImpl implements ProductReviewService {

    private final ProductReviewRepository productReviewRepository;

    private final ConverterService converterService;

//    private final ModelMapper modelMapper;
//
//    private final ProductService productService;

    @Override
    public ProductReviewDto saveProductReview(ProductReviewDto productReviewDto) {
        ProductReviewEntity productReviewEntity = converterService.convertReviewDtoToEntity(productReviewDto);
        productReviewRepository.save(productReviewEntity);
        return productReviewDto;
    }

//    private ProductReviewDto convertEntityToDto(ProductReviewEntity productReview){
//        return modelMapper.map(productReview,ProductReviewDto.class);
//    }
//
//    private ProductReviewEntity convertDtoToEntity(ProductReviewDto productReviewDto){
//        ProductReviewEntity map = modelMapper.map(productReviewDto, ProductReviewEntity.class);
//        map.setProductId(productService.getProductById(productReviewDto.getProductId()));
//        return map;
//    }
}
