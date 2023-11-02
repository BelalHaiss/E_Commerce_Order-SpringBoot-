package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.order.CreateOrderDTO;
import com.haiss.shoppingcart.domain.DTO.order.OrderResponseUserIncluded;
import com.haiss.shoppingcart.domain.DTO.order.UserOrderResponse;
import com.haiss.shoppingcart.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/users/{id}")
    public PaginationResponse<UserOrderResponse> getUserOrders(
            @PathVariable("id") Long id,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return orderService.getUserOrder(id, pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public OrderResponseUserIncluded getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.removeOrder(id);
    }

}
