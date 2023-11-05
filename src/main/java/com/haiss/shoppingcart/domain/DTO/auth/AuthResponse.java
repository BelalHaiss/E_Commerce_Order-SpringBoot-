package com.haiss.shoppingcart.domain.DTO.auth;


import com.haiss.shoppingcart.domain.DTO.UserResponse;
import com.haiss.shoppingcart.domain.DTO.UserWithRoleResponse;
import lombok.Data;

@Data
public class AuthResponse {
    private  String token;
    private UserWithRoleResponse user;
}
