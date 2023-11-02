package com.haiss.shoppingcart.domain.DTO.orderProduct;

import lombok.Data;

@Data
public class PartialPrdouctInfo {
    private Long id;

    private String name;
    private String image;

    private String description;
}
