package com.haiss.shoppingcart.domain.DTO.Product;

import com.haiss.shoppingcart.domain.Interfaces.IProduct;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;

@Data
public class CreateProductDTO implements IProduct {

    @Size(min = 3)
    private String name;
    @URL()
    private String image;

    private String description;

    @DecimalMin("1.00")
    @NotNull
    private BigDecimal price;

    @Min(0)
    private Integer qty=0;

}
