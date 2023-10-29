package com.haiss.shoppingcart.domain.Interfaces;

import java.util.List;

public interface IOrder {


    Long getAddressId();

    List<IOrderProduct> getOrderProducts();


}
