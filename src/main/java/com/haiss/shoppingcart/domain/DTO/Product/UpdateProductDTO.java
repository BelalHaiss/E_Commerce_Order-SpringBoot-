package com.haiss.shoppingcart.domain.DTO.Product;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductDTO {

    @Size(min = 3)
    @Nullable
    private String name;
    private String image;

    private String description;

    @DecimalMin("1.00")
    private BigDecimal price;

    private int qty;
}
