package com.haiss.shoppingcart.domain.DTO.order;

import com.haiss.shoppingcart.domain.DTO.orderProduct.CreateOrderProductDTO;
import com.haiss.shoppingcart.domain.Interfaces.IOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDTO implements IOrder {

    @NotNull
    private Long addressId;


    @Size(min = 1)
    private List<@Valid CreateOrderProductDTO> orderProducts;


    @NotNull
    private Long userId;

}
