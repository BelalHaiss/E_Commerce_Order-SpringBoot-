package com.haiss.shoppingcart.util;


import com.haiss.shoppingcart.domain.entity.Role;
import com.haiss.shoppingcart.domain.enums.RoleEnum;
import com.haiss.shoppingcart.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

interface IDataSeeder {
    //    check if seeded
    boolean alreadySeed();

    void seedData();
}

@Component
@RequiredArgsConstructor
public class DataSeeder implements IDataSeeder {

    private final RoleRepository roleRepository;

    @Override
    public boolean alreadySeed() {
        return roleRepository.existsBy();
    }

    @Override
    public void seedData() {
        if(alreadySeed()) return;
        Role newRole = new Role();
        newRole.setName(RoleEnum.USER);
        Role newRole2 = new Role();
        newRole2.setName(RoleEnum.ADMIN);

        roleRepository.saveAll(List.of(newRole, newRole2));
    }
}
