package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.DTO.UserDTO;
import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.exceptions.DuplicateException;
import com.haiss.shoppingcart.exceptions.NotFoundException;

public interface UserService {

    User createUser(UserDTO user) throws DuplicateException;

    User getUserById(Long id) throws NotFoundException;


}
