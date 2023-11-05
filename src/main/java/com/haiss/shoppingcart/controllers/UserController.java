package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.security.validation.IsSameUser;
import com.haiss.shoppingcart.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/user")
public class UserController {

    final private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{userId}")
    @IsSameUser
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }


}
