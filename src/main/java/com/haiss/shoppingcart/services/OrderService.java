package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.order.CreateOrderDTO;
import com.haiss.shoppingcart.domain.DTO.order.UpdateOrderDTO;
import com.haiss.shoppingcart.domain.DTO.order.UserOrderResponse;
import com.haiss.shoppingcart.exceptions.NotFoundException;

public interface OrderService {

    void createOrder(CreateOrderDTO order);

    void updateOrder(UpdateOrderDTO order);

    void getOrderById(Long id) throws NotFoundException;

    PaginationResponse<UserOrderResponse> getUserOrder(Long userId);

    void removeOrder(Long id) throws NotFoundException;
}
