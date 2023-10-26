package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.DTO.Product.UpdateProductDTO;
import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    final private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;

    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody CreateProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @PatchMapping("/{id}")
    public void updateProductById(@PathVariable("id") Long id, @Valid @RequestBody UpdateProductDTO productDTO) {

        productService.updateById(id, productDTO);
    }

    @GetMapping
    public PaginationResponse<Product> getProducts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSiz", defaultValue = "10", required = false) int pageSiz) {
        return productService.findProductsWithPagination(pageNo, pageSiz);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public  void deleteProduct (@PathVariable ("id") Long id){
         productService.removeById(id);
    }
}
