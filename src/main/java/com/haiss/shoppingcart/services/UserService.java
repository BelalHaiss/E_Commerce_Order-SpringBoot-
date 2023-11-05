package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.exceptions.NotFoundException;

public interface UserService {


    User getUserById(Long id) throws NotFoundException;

    User getUserByUsername(String username) throws NotFoundException;

    void saveNewUser(User user);

    boolean isUsernameExists(String username);
}
