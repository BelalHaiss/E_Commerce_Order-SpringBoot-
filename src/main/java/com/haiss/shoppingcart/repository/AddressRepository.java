package com.haiss.shoppingcart.repository;

import com.haiss.shoppingcart.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long id);
}
