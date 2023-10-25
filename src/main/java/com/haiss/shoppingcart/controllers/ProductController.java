package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    final private ProductService productService ;
    ProductController (ProductService productService){
        this.productService = productService ;
    }

    @PostMapping
    public Product createProduct (@Valid @RequestBody CreateProductDTO productDTO) {
        return  productService.createProduct(productDTO);
    }

    @GetMapping("/{id}")
    public  Product getProduct ( @PathVariable("id") Long id) {
        return  productService.findProductById(id);
    }

}
