package com.haiss.shoppingcart.domain.DTO.order;

import com.haiss.shoppingcart.domain.DTO.orderProduct.CreateOrderProductDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDTO {

    @NotNull
    private Long addressId;

    @NotNull
    @Size(min = 1)
    private List<@Valid CreateOrderProductDTO> orderProducts;


    @NotNull
    private Long userId;


}
