package com.haiss.shoppingcart.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private long id;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "qty", nullable = false)
    private Integer qty;


    @ManyToOne()
    @JoinColumn(name = "order_id",nullable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;




}



