package com.seed.test.domain.product.service;

import com.seed.test.domain.product.dto.ProductRequestDto;
import com.seed.test.domain.product.dto.ProductResponseDto;
import com.seed.test.domain.product.entity.Product;
import com.seed.test.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDto> getAllProduct(){

        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

        productRepository.findAll().forEach(product -> {
            ProductResponseDto productResponseDto = new ProductResponseDto();

            productResponseDto.setNo(product.getProduct_no());
            productResponseDto.setName(product.getName());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setUser_no(product.getUser().getUser_no());
            productResponseDto.setCreated_at(product.getCreated_at());
            productResponseDto.setUpdated_at(product.getUpdated_at());

            productResponseDtoList.add(productResponseDto);
        });

        return productResponseDtoList;
    }

    public ProductResponseDto getOneProductByNo(@PathVariable Long product_no){
        Product product = productRepository.findById(product_no).get();

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNo(product.getProduct_no());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setUser_no(product.getUser().getUser_no());
        productResponseDto.setCreated_at(product.getCreated_at());
        productResponseDto.setUpdated_at(product.getUpdated_at());

        return productResponseDto;
    }

    public ProductResponseDto saveOneProduct(ProductRequestDto productRequestDto){
        Product product = new Product();

        product.setName(productRequestDto.getName());
        product.setPrice(productRequestDto.getPrice());

        Product savedProduct = productRepository.save(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNo(savedProduct.getProduct_no());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setUser_no(product.getUser().getUser_no());
        productResponseDto.setCreated_at(savedProduct.getCreated_at());
        productResponseDto.setUpdated_at(savedProduct.getUpdated_at());

        return productResponseDto;
    }

    public ProductResponseDto updateOneProduct(Long product_no, ProductRequestDto productRequestDto){
        Product product = new Product();

        product.setProduct_no(product_no);
        product.setName(productRequestDto.getName());
        product.setPrice(productRequestDto.getPrice());

        Product updatedProduct = productRepository.save(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNo(updatedProduct.getProduct_no());
        productResponseDto.setName(updatedProduct.getName());
        productResponseDto.setPrice(updatedProduct.getPrice());
        productResponseDto.setUser_no(product.getUser().getUser_no());
        productResponseDto.setCreated_at(updatedProduct.getCreated_at());
        productResponseDto.setUpdated_at(updatedProduct.getUpdated_at());

        return productResponseDto;
    }

    public void deleteOneProduct(Long product_no){
        productRepository.deleteById(product_no);
    }
}
