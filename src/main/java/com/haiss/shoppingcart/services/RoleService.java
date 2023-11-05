package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.entity.Role;
import com.haiss.shoppingcart.domain.enums.RoleEnum;
import com.haiss.shoppingcart.exceptions.NotFoundException;

import java.util.List;

public interface RoleService {

    List<Role> getRoles(List<RoleEnum> name) throws NotFoundException;
}
