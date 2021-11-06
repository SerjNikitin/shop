package com.geekbrains.shop.service;

import com.geekbrains.shop.domain.ProductEntity;
import com.geekbrains.shop.dto.ProductDetailsViewDto;
import com.geekbrains.shop.dto.ProductListViewDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductListViewDto> getProducts();

    ProductListViewDto saveProductAndImage(ProductListViewDto productDto, MultipartFile image);

    ProductEntity getProductById(Long productId);

    ProductDetailsViewDto getProductDtoById(Long productId);
}
