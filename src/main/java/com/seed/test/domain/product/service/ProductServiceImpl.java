package com.seed.test.domain.product.service;

import com.seed.test.domain.product.dto.ProductRequestDto;
import com.seed.test.domain.product.dto.ProductResponseDto;
import com.seed.test.domain.product.entity.Product;
import com.seed.test.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto getOneProductByNo(@PathVariable Long no){
        Product product = productRepository.findById(no).get();

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNo(product.getNo());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
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
        productResponseDto.setNo(savedProduct.getNo());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setCreated_at(savedProduct.getCreated_at());
        productResponseDto.setUpdated_at(savedProduct.getUpdated_at());

        return productResponseDto;
    }

    public ProductResponseDto updateOneProduct(Long no, ProductRequestDto productRequestDto){
        Product product = new Product();

        product.setNo(no);
        product.setName(productRequestDto.getName());
        product.setPrice(productRequestDto.getPrice());

        Product updatedProduct = productRepository.save(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNo(updatedProduct.getNo());
        productResponseDto.setName(updatedProduct.getName());
        productResponseDto.setPrice(updatedProduct.getPrice());
        productResponseDto.setCreated_at(updatedProduct.getCreated_at());
        productResponseDto.setUpdated_at(updatedProduct.getUpdated_at());

        return productResponseDto;
    }

    public void deleteProduct(Long no){
        productRepository.deleteById(no);
    }
}
