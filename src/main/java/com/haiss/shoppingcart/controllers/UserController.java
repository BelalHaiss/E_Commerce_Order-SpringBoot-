package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/user")
public class UserController {

    final private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }


}
