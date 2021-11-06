package com.geekbrains.shop.service.impl;

import com.geekbrains.shop.domain.ProductEntity;
import com.geekbrains.shop.dto.ProductBaseViewDto;
import com.geekbrains.shop.dto.ProductDetailsViewDto;
import com.geekbrains.shop.dto.ProductListViewDto;
import com.geekbrains.shop.dto.ProductReviewDto;
import com.geekbrains.shop.repository.ProductRepository;
import com.geekbrains.shop.service.CategoryService;
import com.geekbrains.shop.service.ConverterService;
import com.geekbrains.shop.service.FileService;
import com.geekbrains.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;

    private final ProductRepository productRepository;

    private final FileService fileService;

    private final CategoryService categoryService;

    private ConverterService converterService;

    @Autowired
    public void setConverterService(ConverterService converterService) {
        this.converterService = converterService;
    }

    @Override
    @Transactional
    public ProductListViewDto saveProductAndImage(ProductListViewDto productDto, MultipartFile image) {
        ProductEntity product = convertDtoToEntity(productDto);
        ProductEntity savedProduct = productRepository.save(product);
        if (image != null && !image.isEmpty()) {
            Path pathImage = fileService.saveProductImage(image);
            savedProduct.setImageLink(pathImage.toString());
            productRepository.save(savedProduct);
        }
        return convertEntityToDto(savedProduct, ProductListViewDto.class);
    }

    @Override
    public ProductEntity getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @Override
    public ProductDetailsViewDto getProductDtoById(Long productId) {
        ProductEntity productById = getProductById(productId);
        ProductDetailsViewDto productDetailsViewDto = convertEntityToDto(productById, ProductDetailsViewDto.class);
        Set<ProductReviewDto> collect = productById
                .getProductReview()
                .stream()
                .map(converterService::convertReviewEntityToDto)
                .collect(Collectors.toSet());
        productDetailsViewDto.setReviewEntities(collect);
        return productDetailsViewDto;
    }

    private <T extends ProductBaseViewDto> ProductEntity convertDtoToEntity(T productDto) {
        ProductEntity entity = modelMapper.map(productDto, ProductEntity.class);
        entity.setCategory(categoryService.findCategoryById(productDto.getCategoryId()));
        return entity;
    }

    @Override
    public List<ProductListViewDto> getProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(productEntity -> convertEntityToDto(productEntity, ProductListViewDto.class))
                .collect(Collectors.toList());
    }

    private <T extends ProductBaseViewDto> T convertEntityToDto(ProductEntity savedEntity, Class<T> dto) {
        T map = modelMapper.map(savedEntity, dto);
        map.setCategoryId(savedEntity.getCategory().getId());
        return map;
    }

}
