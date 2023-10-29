package com.haiss.shoppingcart.domain.DTO.order;

import com.haiss.shoppingcart.domain.Interfaces.IOrder;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UpdateOrderDTO implements IOrder {

    @Nullable
    private Long addressId;

    @Size(min = 1)
    private List<@Valid CreateOrderDTO> orderProducts;


}
