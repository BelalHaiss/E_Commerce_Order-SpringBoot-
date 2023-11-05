package com.haiss.shoppingcart.repository;

import com.haiss.shoppingcart.domain.entity.Role;
import com.haiss.shoppingcart.domain.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
    boolean existsBy();


}
