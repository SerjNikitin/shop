package com.geekbrains.shop.dto;

import com.geekbrains.shop.domain.ProductReviewEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

//@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsViewDto extends ProductBaseViewDto {

    private Set<ProductReviewDto> reviewEntities;
}