package com.haiss.shoppingcart.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank
    private String name;

}
