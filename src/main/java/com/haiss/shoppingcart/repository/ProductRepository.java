package com.haiss.shoppingcart.repository;

import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.domain.enums.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByStatus(ProductStatus status, Pageable pageable);

}
