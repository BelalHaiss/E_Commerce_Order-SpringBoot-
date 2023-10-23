package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.DTO.UserDTO;
import com.haiss.shoppingcart.entity.User;
import com.haiss.shoppingcart.repository.UserRepository;
import com.haiss.shoppingcart.services.UserService;


public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(UserDTO user) {
        User newUser = new User();
        newUser.setName(user.getName());
        User createdUser = userRepo.save(newUser);
        System.out.println("createdUser is " +createdUser);
        return createdUser;
    }

    @Override
    public User getUserById(Long id) throws Exception {
        return userRepo.getReferenceById(id);
    }
}
