package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.order.CreateOrderDTO;
import com.haiss.shoppingcart.domain.DTO.order.OrderResponseUserIncluded;
import com.haiss.shoppingcart.domain.DTO.order.UserOrderResponse;
import com.haiss.shoppingcart.exceptions.NotFoundException;

public interface OrderService {

    void createOrder(CreateOrderDTO order);


    OrderResponseUserIncluded getOrderById(Long id) throws NotFoundException;

    PaginationResponse<UserOrderResponse> getUserOrder(Long userId,int pageNo ,int pageSize);

    void removeOrder(Long id) throws NotFoundException;
}
