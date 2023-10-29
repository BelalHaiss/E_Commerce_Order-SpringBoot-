package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.order.CreateOrderDTO;
import com.haiss.shoppingcart.domain.DTO.order.UpdateOrderDTO;
import com.haiss.shoppingcart.domain.DTO.order.UserOrderResponse;
import com.haiss.shoppingcart.domain.entity.Order;
import com.haiss.shoppingcart.domain.entity.OrderProduct;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.repository.OrderRepository;
import com.haiss.shoppingcart.services.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final AddressService addressService;
    private final ProductService productService;
    private final UserService userService;

    OrderServiceImpl(UserService userService, OrderRepository orderRepository, OrderProductService orderProductService, ProductService productService, AddressService addressService) {
        this.orderRepository = orderRepository;
        this.orderProductService = orderProductService;
        this.addressService = addressService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public void createOrder(CreateOrderDTO orderDTO) {
        Order newOrder = new Order();
        newOrder.setTotalPrice(new BigDecimal(0));
        List<OrderProduct> orderProducts = new ArrayList<>(orderDTO.getOrderProducts().size());
        //        loop and validate
        orderDTO.getOrderProducts().forEach((orderProductDTO -> {
            OrderProduct orderProduct = orderProductService.handleOrderPrduct(orderProductDTO);
            orderProduct.setOrder(newOrder);
            orderProducts.add(orderProduct);
            newOrder.setTotalPrice(newOrder.getTotalPrice().add(
                    (orderProduct.getUnitPrice().multiply(new BigDecimal(orderProductDTO.getQty())))
            ));
        }));
        newOrder.setOrderProducts(orderProducts);
        newOrder.setAddress(addressService.getAddressById(orderDTO.getAddressId()));
        newOrder.setUser(userService.getUserById(orderDTO.getUserId()));
        orderRepository.save(newOrder);

        orderProducts.forEach((product) -> {
            productService.changeProductQty(product.getId(), product.getQty());
        });
    }

    @Override
    public void updateOrder(UpdateOrderDTO order) {

    }

    @Override
    public void getOrderById(Long id) throws NotFoundException {

    }

    @Override
    public PaginationResponse<UserOrderResponse> getUserOrder(Long userId) {
        return null;
    }

    @Override
    public void removeOrder(Long id) throws NotFoundException {

    }
}
