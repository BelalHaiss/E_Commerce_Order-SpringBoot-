package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.entity.Role;
import com.haiss.shoppingcart.domain.enums.RoleEnum;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.repository.RoleRepository;
import com.haiss.shoppingcart.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> getRoles(List<RoleEnum> roles) throws NotFoundException {

        return roles.stream().map(this::getRoleByName).collect(Collectors.toList());
    }


    private Role getRoleByName(RoleEnum role) throws NotFoundException {
        return roleRepository.findByName(role).orElseThrow(() -> new NotFoundException("no role with this name"));

    }

}
