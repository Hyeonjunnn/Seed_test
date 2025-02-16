package com.seed.test.domain.product.controller;

import com.seed.test.domain.product.dto.ProductRequestDto;
import com.seed.test.domain.product.dto.ProductResponseDto;
import com.seed.test.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "상품 API", description = "상품 CRUD API")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "상품 조회", description = "상품을 조회합니다.")
    @GetMapping("/{no}")
    public ResponseEntity<ProductResponseDto> getOneProduct(@PathVariable Long no){

        ProductResponseDto productResponseDto = productService.getOneProductByNo(no);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @Operation(summary = "상품 등록", description = "상품을 등록합니다.")
    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto){

        ProductResponseDto productResponseDto = productService.saveOneProduct(productRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @Operation(summary = "상품 수정", description = "상품을 수정합니다.")
    @PutMapping("/{no}")
    public ResponseEntity<ProductResponseDto> createProduct(@PathVariable Long no,
                                                      @RequestBody ProductRequestDto productRequestDto){

        ProductResponseDto productResponseDto = productService.updateOneProduct(no, productRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @Operation(summary = "상품 삭제", description = "상품을 삭제합니다.")
    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long no){

        productService.deleteProduct(no);

        return ResponseEntity.status(HttpStatus.OK).body("상품이 삭제되었습니다.");
    }
}
