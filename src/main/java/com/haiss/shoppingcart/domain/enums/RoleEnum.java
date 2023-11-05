package com.haiss.shoppingcart.domain.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum RoleEnum {
    ADMIN("ADMIN"), USER("USER");

    private final String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public static RoleEnum fromValue(String value) {
        for (RoleEnum role : RoleEnum.values()) {
            if (role.getValue().equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + value);
    }

    public String getValue() {
        return value;
    }

    public GrantedAuthority getRole() {
        return new SimpleGrantedAuthority("ROLE_" + getValue());
    }
}
