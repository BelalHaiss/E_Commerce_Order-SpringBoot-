package com.haiss.shoppingcart.domain.Interfaces;

import com.haiss.shoppingcart.domain.enums.ProductStatus;

import java.math.BigDecimal;

public interface IProduct {
    Integer getQty();

    String getName();

    BigDecimal getPrice();

    String getImage();

    String getDescription();

    String getStatus();
}
