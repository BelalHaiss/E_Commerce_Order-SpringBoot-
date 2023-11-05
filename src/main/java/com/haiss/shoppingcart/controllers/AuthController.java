package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.auth.AuthResponse;
import com.haiss.shoppingcart.domain.DTO.auth.LoginDTO;
import com.haiss.shoppingcart.domain.DTO.auth.RegisterDTO;
import com.haiss.shoppingcart.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@Valid @RequestBody LoginDTO login) {
        return authService.login(login);
    }

    @PostMapping ("/register")
    public Object registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        return authService.register(registerDTO);
    }


}
