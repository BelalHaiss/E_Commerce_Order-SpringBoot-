package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.UserDTO;
import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/user")
public class UserController {

    final private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User CreateUser(@Valid @RequestBody UserDTO userDto) {

        return userService.createUser(userDto);

    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

//    get userById

}
