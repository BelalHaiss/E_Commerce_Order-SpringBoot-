package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.DTO.UserDTO;
import com.haiss.shoppingcart.entity.User;
import com.haiss.shoppingcart.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/user")

public class UserController {

   final private UserService userService;

    UserController(UserService userService) {
        this.userService =userService ;
    }

    @PostMapping
    public  User CreateUser (@Valid @RequestBody UserDTO userDto) {
            return    userService.createUser(userDto);
    }

//    get userById

}
