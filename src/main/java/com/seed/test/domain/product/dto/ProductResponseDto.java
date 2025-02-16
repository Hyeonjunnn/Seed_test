package com.seed.test.domain.product.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private Long no;

    private String name;

    private Long price;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
