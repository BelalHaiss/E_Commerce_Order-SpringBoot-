package com.haiss.shoppingcart.domain.DTO.orderProduct;

import com.haiss.shoppingcart.domain.DTO.Product.ProductResponse;

import java.math.BigDecimal;

public class OrderProductResponse {
    private long id;
    private BigDecimal unitPrice;
    private Integer qty;
    private ProductResponse product;
}
