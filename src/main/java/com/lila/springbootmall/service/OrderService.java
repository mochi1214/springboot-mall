package com.lila.springbootmall.service;

import com.lila.springbootmall.dto.CreateOrderRequest;
import com.lila.springbootmall.dto.OrderQueryParams;
import com.lila.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
