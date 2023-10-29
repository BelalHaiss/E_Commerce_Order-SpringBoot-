package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.DTO.Product.ProductResponse;
import com.haiss.shoppingcart.domain.DTO.Product.UpdateProductDTO;
import com.haiss.shoppingcart.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    final private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;

    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody CreateProductDTO productDTO) {
        productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}")
    public void updateProductById(@PathVariable("id") Long id, @Valid @RequestBody UpdateProductDTO productDTO) {

        productService.updateById(id, productDTO);
    }

    @GetMapping
    public PaginationResponse<ProductResponse> getProducts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSiz", defaultValue = "10", required = false) int pageSiz) {
        return productService.findProductsWithPagination(pageNo, pageSiz);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.removeById(id);
    }
}
