package com.haiss.shoppingcart.repository;

import com.haiss.shoppingcart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}