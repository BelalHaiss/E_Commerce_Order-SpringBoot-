package com.haiss.shoppingcart.domain.DTO.order;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.haiss.shoppingcart.domain.entity.User;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
public class OrderResponseUserIncluded {


    @JsonUnwrapped
    @Embedded
    private UserOrderResponse orderResponse;
    private User user;

}
