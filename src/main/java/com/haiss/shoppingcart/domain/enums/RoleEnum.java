package com.haiss.shoppingcart.domain.enums;

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
}
