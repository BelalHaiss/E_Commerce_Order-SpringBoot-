package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.orderProduct.CreateOrderProductDTO;
import com.haiss.shoppingcart.domain.entity.OrderProduct;
import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.services.OrderProductService;
import com.haiss.shoppingcart.services.ProductService;

public class OrderProductServiceImpl implements OrderProductService {
    private ProductService productService;

    OrderProductServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public OrderProduct handleOrderPrduct(CreateOrderProductDTO orderProductDTO) {
        Product productEntity = productService.validateOrderProduct(orderProductDTO);
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(productEntity);
        orderProduct.setQty(orderProduct.getQty());
        orderProduct.setUnitPrice(productEntity.getPrice());
        return orderProduct;
    }
}
