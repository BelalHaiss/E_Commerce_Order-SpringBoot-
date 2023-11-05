package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.UserWithRoleResponse;
import com.haiss.shoppingcart.domain.DTO.auth.AuthResponse;
import com.haiss.shoppingcart.domain.DTO.auth.ExtendedUserDetails;
import com.haiss.shoppingcart.domain.DTO.auth.LoginDTO;
import com.haiss.shoppingcart.domain.DTO.auth.RegisterDTO;
import com.haiss.shoppingcart.domain.entity.Role;
import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.domain.enums.RoleEnum;
import com.haiss.shoppingcart.domain.mapping.UserMapper;
import com.haiss.shoppingcart.exceptions.DuplicateException;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.security.JwtTokenUtil;
import com.haiss.shoppingcart.services.AuthService;
import com.haiss.shoppingcart.services.RoleService;
import com.haiss.shoppingcart.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginDTO login) throws NotFoundException {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            ExtendedUserDetails fullUserDetails = (ExtendedUserDetails) authentication.getPrincipal();
            System.out.println("fullUserDetails" +fullUserDetails);

            AuthResponse response = new AuthResponse();
            UserWithRoleResponse userDTO = userMapper.mapToDTO(fullUserDetails);
            System.out.println("userDTO" + userDTO);
            response.setUser(userDTO);
            String token = jwtTokenUtil.genrateToken(authentication);
            response.setToken(token);
            return response;
        } catch (Exception ex) {
            throw new NotFoundException("wrong credentials");
        }


    }

    @Override
    public Object register(RegisterDTO register) throws DuplicateException {
        if (userService.isUsernameExists(register.getUsername()))
            throw new DuplicateException("username exists");

        User newUser = userMapper.mapToUserEntity(register);

        newUser.setPassword(passwordEncoder.encode(register.getPassword()));
        System.out.println(newUser);
        List<Role> userRoles = roleService.getRoles(List.of(RoleEnum.USER));
        System.out.println(newUser);
        System.out.println(userRoles);
        newUser.setRoles(userRoles);
        userService.saveNewUser(newUser);
        return null;
    }
}
