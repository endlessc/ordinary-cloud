package com.me.ordinarycloud.order.service;

import com.me.ordinarycloud.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Integer userId, Integer commodityId);

    List<Order> selectUserOrders(Integer userId);
}
