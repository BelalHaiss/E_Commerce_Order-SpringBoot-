package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.order.CreateOrderDTO;
import com.haiss.shoppingcart.domain.DTO.order.OrderResponseUserIncluded;
import com.haiss.shoppingcart.domain.DTO.order.UserOrderResponse;
import com.haiss.shoppingcart.domain.entity.Order;
import com.haiss.shoppingcart.domain.entity.OrderProduct;
import com.haiss.shoppingcart.domain.mapping.OrderMapper;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.repository.OrderRepository;
import com.haiss.shoppingcart.services.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final AddressService addressService;
    private final ProductService productService;
    private final UserService userService;
    private final OrderMapper orderMapper;

    OrderServiceImpl(OrderMapper orderMapper, UserService userService, OrderRepository orderRepository, OrderProductService orderProductService, ProductService productService, AddressService addressService) {
        this.orderRepository = orderRepository;
        this.orderProductService = orderProductService;
        this.addressService = addressService;
        this.productService = productService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public void createOrder(CreateOrderDTO orderDTO) {
        Order newOrder = new Order();
        List<OrderProduct> orderProducts = new ArrayList<>(orderDTO.getOrderProducts().size());
        //        loop and validate
        orderDTO.getOrderProducts().forEach((orderProductDTO -> {
            OrderProduct orderProduct = orderProductService.handleOrderPrduct(orderProductDTO);
            orderProduct.setOrder(newOrder);
            orderProducts.add(orderProduct);
        }));

        newOrder.setTotalPrice(orderTotalAmount(orderProducts).get());
        newOrder.setOrderProducts(orderProducts);
        newOrder.setAddress(addressService.getAddressById(orderDTO.getAddressId()));
        newOrder.setUser(userService.getUserById(orderDTO.getUserId()));
        orderRepository.save(newOrder);
        orderDTO.getOrderProducts().forEach((product) -> {
            productService.changeProductQty(product.getProductId(), product.getQty(), false);
        });
    }


    @Override
    public OrderResponseUserIncluded getOrderById(Long id) throws NotFoundException {
        Order orderEnity = findOrderById(id);
        UserOrderResponse order = orderMapper.mapToOrderResponse(orderEnity);
        OrderResponseUserIncluded orderResponse = new OrderResponseUserIncluded();
        orderResponse.setOrderResponse(order);
        orderResponse.setUser(orderEnity.getUser());
        return orderResponse;
    }


    @Override
    public PaginationResponse<UserOrderResponse> getUserOrder(Long userId, int pageNo, int pageSize) {
        Pageable page = PageRequest.of(pageNo, pageSize);
        Page<Order> orderPage = orderRepository.findByUserId(userId, page);

        return orderMapper.mapToUserOrderPagination(orderPage, pageNo, pageSize);
    }

    @Override
    @Transactional
    public void removeOrder(Long id) throws NotFoundException {

        Order orderEntity = findOrderById(id);
        orderEntity.getOrderProducts().forEach((orderProduct -> {
            productService.changeProductQty(orderProduct.getProduct().getId(), orderProduct.getQty(), true);
        }));
        orderRepository.delete(orderEntity);
    }


//    utils for orders

    private Optional<BigDecimal> orderTotalAmount(List<OrderProduct> orderProducts) {
        return orderProducts.stream().map((orderProduct -> orderProduct.getUnitPrice().multiply(new BigDecimal(orderProduct.getQty())))).reduce(BigDecimal::add);
    }

    private Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order id is wrong"));
    }
}
