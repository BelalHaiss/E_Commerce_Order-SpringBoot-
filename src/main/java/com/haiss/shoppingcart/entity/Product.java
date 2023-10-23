package com.haiss.shoppingcart.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column( nullable = false)
    private String name;
    @Column( nullable = false)
    private String image;

    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name="qty",nullable = false)
    private int qty ;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;
}
