package com.haiss.shoppingcart.domain.DTO.orderProduct;

import com.haiss.shoppingcart.domain.Interfaces.IOrderProduct;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderProductDTO implements IOrderProduct {

    @Min(1)
    private Integer qty;

    @NotNull
    private Long productId;
}
