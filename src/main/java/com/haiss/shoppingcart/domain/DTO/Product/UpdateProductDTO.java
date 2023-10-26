package com.haiss.shoppingcart.domain.DTO.Product;

import com.haiss.shoppingcart.domain.Interfaces.IProduct;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Data
public class UpdateProductDTO implements IProduct {

    @Size(min = 3)
    @Nullable
    private String name;
    @URL
    @Nullable
    private String image;

    private String description;

    @DecimalMin("1.00")
    private BigDecimal price;

    @Min(0)
    @Nullable
    private Integer qty;
}
