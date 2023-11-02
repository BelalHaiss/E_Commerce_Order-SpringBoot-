package com.haiss.shoppingcart.repository;

import com.haiss.shoppingcart.domain.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Page<Order> findByUserId(Long id, Pageable page);
}
