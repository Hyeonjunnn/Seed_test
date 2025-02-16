package com.seed.test.domain.product.controller;

import com.seed.test.domain.product.dto.ProductRequestDto;
import com.seed.test.domain.product.dto.ProductResponseDto;
import com.seed.test.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "상품 API", description = "상품 CRUD API")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "상품 모두 조회", description = "상품을 모두 조회합니다.")
    @GetMapping("")
    public ResponseEntity<List<ProductResponseDto>> getAllProduct(){

        List<ProductResponseDto> productResponseDtoList = productService.getAllProduct();

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDtoList);
    }

    @Operation(summary = "상품 한 건 조회", description = "상품 한 건을 조회합니다.")
    @GetMapping("/{product_no}")
    public ResponseEntity<ProductResponseDto> getOneProduct(@PathVariable Long product_no){

        ProductResponseDto productResponseDto = productService.getOneProductByNo(product_no);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @Operation(summary = "상품 등록", description = "상품을 등록합니다.")
    @PostMapping()
    public ResponseEntity<ProductResponseDto> createOneProduct(@RequestBody ProductRequestDto productRequestDto){

        ProductResponseDto productResponseDto = productService.saveOneProduct(productRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @Operation(summary = "상품 수정", description = "상품을 수정합니다.")
    @PutMapping("/{product_no}")
    public ResponseEntity<ProductResponseDto> updateOneProduct(@PathVariable Long product_no,
                                                      @RequestBody ProductRequestDto productRequestDto){

        ProductResponseDto productResponseDto = productService.updateOneProduct(product_no, productRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @Operation(summary = "상품 삭제", description = "상품을 삭제합니다.")
    @DeleteMapping("/{product_no}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long product_no){

        productService.deleteOneProduct(product_no);

        return ResponseEntity.status(HttpStatus.OK).body("상품이 삭제되었습니다.");
    }
}
