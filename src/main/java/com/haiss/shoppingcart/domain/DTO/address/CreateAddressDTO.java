package com.haiss.shoppingcart.domain.DTO.address;


import com.haiss.shoppingcart.domain.Interfaces.IAddress;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAddressDTO implements IAddress {


    @Size(min = 2)
    private String street;

    @Size(min = 2)
    private String city;
    @Size(min = 2)
    private String country;


}
