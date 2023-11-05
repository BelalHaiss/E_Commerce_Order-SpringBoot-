package com.haiss.shoppingcart.domain.DTO.auth;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDTO {

    @NotNull
    private  String username;

    @NotNull
    @Size(min = 6)
    private  String password;
}
