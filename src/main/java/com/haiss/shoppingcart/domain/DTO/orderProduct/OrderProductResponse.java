package com.haiss.shoppingcart.domain.DTO.orderProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Transient;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProductResponse {
    private long id;
    private BigDecimal unitPrice;
    private Integer qty;


    @JsonProperty("product_ref")
    private PartialPrdouctInfo product;

    @Transient
    public BigDecimal getTotalPrice() {
        return  unitPrice.multiply(new BigDecimal(qty))  ;
    }
}
