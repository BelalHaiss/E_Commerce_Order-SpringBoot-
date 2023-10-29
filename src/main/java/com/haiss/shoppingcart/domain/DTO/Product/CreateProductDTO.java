package com.haiss.shoppingcart.domain.DTO.Product;

import com.haiss.shoppingcart.domain.Interfaces.IProduct;
import com.haiss.shoppingcart.domain.enums.EnumValidator;
import com.haiss.shoppingcart.domain.enums.ProductStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

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
    private Integer qty = 0;

    @NotNull
    @EnumValidator(enumClass = ProductStatus.class)
    private String status;

}
