package com.haiss.shoppingcart.domain.DTO.Product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private Long id;

    private String name;
    private String image;

    private String description;

    private BigDecimal price;

    private Integer qty;

}
