package com.geekbrains.shop.controller;

import com.geekbrains.shop.dto.ProductDetailsViewDto;
import com.geekbrains.shop.dto.ProductListViewDto;
import com.geekbrains.shop.service.ConverterService;
import com.geekbrains.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.geekbrains.shop.domain.constant.RestControllerName.API_V1;
import static com.geekbrains.shop.domain.constant.RestControllerName.PRODUCT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(API_V1 + PRODUCT)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

//    private final ConverterService convertService;

    @GetMapping
    public List<ProductListViewDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public ProductDetailsViewDto getProductById(@PathVariable Long productId) {
        return productService.getProductDtoById(productId);
    }

    @RequestMapping(method = {POST,PUT},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProductListViewDto saveProduct(@RequestPart ProductListViewDto product,
                                          @RequestPart(required = false) MultipartFile image) {
        return productService.saveProductAndImage(product, image);
    }

}
