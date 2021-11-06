package com.geekbrains.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewDto {

    private UserDto userId;

    private String comment;

    private Long productId;

    private int rating;

    private LocalDateTime create;

    private LocalDateTime update;
}
