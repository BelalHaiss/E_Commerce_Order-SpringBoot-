package com.haiss.shoppingcart.security;

import com.haiss.shoppingcart.domain.DTO.auth.ExtendedUserDetails;
import com.haiss.shoppingcart.domain.entity.Role;
import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.domain.mapping.UserMapper;
import com.haiss.shoppingcart.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    private final UserMapper userMapper;


    private ExtendedUserDetails getFullUserDetails(User userEntity) {
        ExtendedUserDetails userDetails = userMapper.mapToFullUserDetails(userEntity);
        userDetails.setAuthorities(mapRoles(userEntity.getRoles()));

        return userDetails;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);

        return getFullUserDetails(user);
    }

    private Collection<GrantedAuthority> mapRoles(List<Role> roles) {
        return roles.stream().map((role) -> new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());
    }

}
