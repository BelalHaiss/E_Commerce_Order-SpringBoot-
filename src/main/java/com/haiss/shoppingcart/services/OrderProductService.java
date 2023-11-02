package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.DTO.orderProduct.CreateOrderProductDTO;
import com.haiss.shoppingcart.domain.entity.OrderProduct;

public interface OrderProductService {

    OrderProduct handleOrderPrduct(CreateOrderProductDTO orderProductDTO);
}
