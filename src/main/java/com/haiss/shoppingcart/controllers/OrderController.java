package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.order.CreateOrderDTO;
import com.haiss.shoppingcart.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody @Valid CreateOrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
