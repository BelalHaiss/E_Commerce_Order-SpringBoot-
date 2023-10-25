package com.haiss.shoppingcart.domain.Interfaces;

import java.math.BigDecimal;

public interface IProduct {
    Integer getQty();

    String getName();

    BigDecimal getPrice();

    String getImage();

    String getDescription();
}
