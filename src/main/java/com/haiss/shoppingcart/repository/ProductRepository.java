package com.haiss.shoppingcart.repository;

import com.haiss.shoppingcart.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
