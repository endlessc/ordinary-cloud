package com.me.ordinarycloud.order.controller;

import com.me.ordinarycloud.api.OrderApi;
import com.me.ordinarycloud.entity.Order;
import com.me.ordinarycloud.entity.User;
import com.me.ordinarycloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class OrderApiImpl implements OrderApi {

    private final OrderService orderService;

    public OrderApiImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public List<Order> selectUserOrders(User user) {
        return orderService.selectUserOrders(user.getUserId());
    }

}
