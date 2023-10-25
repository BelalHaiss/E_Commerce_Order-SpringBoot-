package com.haiss.shoppingcart.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "total_price",precision = 10,scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private  Instant updatedAt;

    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}

