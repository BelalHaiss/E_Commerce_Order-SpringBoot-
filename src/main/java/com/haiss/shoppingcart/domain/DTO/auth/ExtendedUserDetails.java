package com.haiss.shoppingcart.domain.DTO.auth;

import com.haiss.shoppingcart.domain.entity.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
public class ExtendedUserDetails implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;
    private String password;

    private String username;

    private Long id;

    private String name;

    private List<Role> roles;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
