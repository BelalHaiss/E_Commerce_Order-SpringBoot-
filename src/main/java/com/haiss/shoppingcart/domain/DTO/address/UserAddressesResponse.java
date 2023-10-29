package com.haiss.shoppingcart.domain.DTO.address;

import lombok.Data;

@Data
public class UserAddressesResponse {
    private Long id;

    private String street;

    private String city;

    private String country;


}
