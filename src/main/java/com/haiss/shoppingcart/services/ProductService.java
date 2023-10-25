package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.DTO.Product.UpdateProductDTO;
import com.haiss.shoppingcart.domain.Interfaces.IProduct;
import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.exceptions.NotFoundException;

public interface ProductService {


    Product createProduct (CreateProductDTO product);


// findById
    Product findProductById (Long id) throws NotFoundException ;
    // findProducts with pagination
    PaginationResponse<Product> findProductsWithPagination (int pageNo, int PageSize )  ;

//    update product

    void updateById(Long id , UpdateProductDTO product) throws NotFoundException;
//    remove product

    void removeById(Long id);

}
