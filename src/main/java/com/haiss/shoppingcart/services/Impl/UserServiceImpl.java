package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.UserDTO;
import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.exceptions.DuplicateException;
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
    public User createUser(UserDTO user) {

        Boolean isExist = userRepo.existsByName(user.getName());
        if (isExist) throw new DuplicateException("user exists with same name");
        User newUser = new User();
        newUser.setName(user.getName());
        return userRepo.save(newUser);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("haiss"));
    }
}
