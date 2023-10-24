package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.DTO.UserDTO;
import com.haiss.shoppingcart.entity.User;
import com.haiss.shoppingcart.exceptions.DuplicateException;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLException;

public interface UserService {

    User createUser(UserDTO user) throws DuplicateException;

    User getUserById(Long id) throws NotFoundException;


}
