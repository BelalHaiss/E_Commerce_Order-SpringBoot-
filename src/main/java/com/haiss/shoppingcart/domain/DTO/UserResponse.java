package com.haiss.shoppingcart.domain.DTO;


import com.haiss.shoppingcart.domain.enums.RoleEnum;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private String username;
    private String name;
    private Long id;
    private List<RoleEnum> roles;
}
