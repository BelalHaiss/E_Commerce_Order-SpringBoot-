package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.DTO.Product.ProductResponse;
import com.haiss.shoppingcart.domain.DTO.Product.UpdateProductDTO;
import com.haiss.shoppingcart.domain.DTO.orderProduct.CreateOrderProductDTO;
import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;

public interface ProductService {


    void createProduct(CreateProductDTO product);

    // findById
    Product findProductById(Long id) throws NotFoundException;
    ProductResponse getProductById(Long id) throws NotFoundException;


//    update product

    // findProducts with pagination
    PaginationResponse<ProductResponse> findProductsWithPagination(int pageNo, int PageSize);
//    remove product

    void updateById(Long id, UpdateProductDTO product) throws NotFoundException;

    void removeById(Long id) throws NotFoundException;

    Product validateOrderProduct(CreateOrderProductDTO productDTO) throws DataIntegrityViolationException, NotFoundException;

    void changeProductQty(long productId, int qty);

}
