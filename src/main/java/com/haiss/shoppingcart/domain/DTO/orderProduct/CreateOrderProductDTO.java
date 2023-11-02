package com.haiss.shoppingcart.domain.DTO.orderProduct;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderProductDTO {

    @NotNull
    @Min(1)
    private Integer qty;

    @NotNull
    private Long productId;
}
