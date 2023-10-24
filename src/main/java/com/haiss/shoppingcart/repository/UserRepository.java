package com.haiss.shoppingcart.repository;

import com.haiss.shoppingcart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    Boolean existsByName(String name) ;
}
