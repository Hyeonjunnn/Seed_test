package com.seed.test.domain.product.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String name;

    private Long price;

    private Long user_no;
}
