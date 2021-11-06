package com.geekbrains.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductBaseViewDto {
    private Long id;

    private String title;

    private Double price;

    private String imageLink;

    private Long categoryId;
}
