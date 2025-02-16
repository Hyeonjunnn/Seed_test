package com.seed.test.domain.product.service;

import com.seed.test.domain.product.dto.ProductRequestDto;
import com.seed.test.domain.product.dto.ProductResponseDto;
import com.seed.test.domain.user.dto.UserRequestDto;
import com.seed.test.domain.user.dto.UserResponseDto;

public interface ProductService {

    public ProductResponseDto getOneProductByNo(Long no);

    public ProductResponseDto saveOneProduct(ProductRequestDto productRequestDto);

    public ProductResponseDto updateOneProduct(Long no, ProductRequestDto productRequestDto);

    public void deleteProduct(Long no);

}
