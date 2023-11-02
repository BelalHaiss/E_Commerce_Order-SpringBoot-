package com.haiss.shoppingcart.domain.mapping;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.Product.ProductResponse;
import com.haiss.shoppingcart.domain.DTO.order.UserOrderResponse;
import com.haiss.shoppingcart.domain.entity.Order;
import com.haiss.shoppingcart.domain.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    UserOrderResponse mapToOrderResponse(Order orderEntity);

    List<UserOrderResponse> mapToOrderResponse(List<Order> orderEntity);

    PaginationResponse<UserOrderResponse> mapToUserOrderPagination(Page<Order>orderPage,int pageNo, int pageSize);


}
