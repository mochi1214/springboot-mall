package com.lila.springbootmall.service;

import com.lila.springbootmall.dto.CreateOrderRequest;
import com.lila.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
