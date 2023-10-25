package com.haiss.shoppingcart.repository;

import com.haiss.shoppingcart.domain.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
