package com.haiss.shoppingcart.domain.DTO.address;


import com.haiss.shoppingcart.domain.Interfaces.IAddress;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateAddressDTO implements IAddress {


    @Size(min = 2)
    @Nullable
    private String street;

    @Size(min = 2)
    @Nullable
    private String city;

    @Size(min = 2)
    @Nullable
    private String country;


}

