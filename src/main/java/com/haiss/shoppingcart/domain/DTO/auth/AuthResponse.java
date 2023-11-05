package com.haiss.shoppingcart.domain.DTO.auth;


import com.haiss.shoppingcart.domain.DTO.UserResponse;
import lombok.Data;

@Data
public class AuthResponse {
    private  String token;
    private  UserResponse user;
}
