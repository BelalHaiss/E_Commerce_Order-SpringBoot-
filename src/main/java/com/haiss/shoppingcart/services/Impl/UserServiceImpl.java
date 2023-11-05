package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.repository.UserRepository;
import com.haiss.shoppingcart.services.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User getUserById(Long id) {

        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("user not found"));
    }

    @Override
    public User getUserByUsername(String username) throws NotFoundException {
        return userRepo.findByUsername(username).orElseThrow(() -> new NotFoundException("user not found"));
    }

    @Override
    public void saveNewUser(User user) {
        userRepo.save(user);
    }


    public boolean isUsernameExists(String username) {
        return userRepo.existsByUsername(username);
    }

}
