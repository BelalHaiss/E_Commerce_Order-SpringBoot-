package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.DTO.auth.AuthResponse;
import com.haiss.shoppingcart.domain.DTO.auth.LoginDTO;
import com.haiss.shoppingcart.domain.DTO.auth.RegisterDTO;
import com.haiss.shoppingcart.exceptions.DuplicateException;
import com.haiss.shoppingcart.exceptions.NotFoundException;

public interface AuthService {

    AuthResponse login(LoginDTO login) throws NotFoundException;

    Object register(RegisterDTO register) throws DuplicateException;

}
