package com.seed.test.domain.product.service;

import com.seed.test.domain.product.dto.ProductRequestDto;
import com.seed.test.domain.product.dto.ProductResponseDto;
import com.seed.test.domain.user.dto.UserRequestDto;
import com.seed.test.domain.user.dto.UserResponseDto;

import java.util.List;

public interface ProductService {

    public List<ProductResponseDto> getAllProduct();

    public ProductResponseDto getOneProductByNo(Long product_no);

    public ProductResponseDto saveOneProduct(ProductRequestDto productRequestDto);

    public ProductResponseDto updateOneProduct(Long product_no, ProductRequestDto productRequestDto);

    public void deleteOneProduct(Long product_no);

}
