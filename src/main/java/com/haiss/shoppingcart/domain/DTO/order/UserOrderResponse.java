package com.haiss.shoppingcart.domain.DTO.order;

import com.haiss.shoppingcart.domain.DTO.address.UserAddressesResponse;
import com.haiss.shoppingcart.domain.DTO.orderProduct.OrderProductResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
public class UserOrderResponse {

    private Long id;
    private BigDecimal totalPrice;
    private Instant createdAt;
    private Instant updatedAt;

    private List<OrderProductResponse> orderProducts;
    private UserAddressesResponse address;
}
