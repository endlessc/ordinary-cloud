package com.me.ordinarycloud.order.controller;

import com.me.ordinarycloud.entity.Order;
import com.me.ordinarycloud.entity.User;
import com.me.ordinarycloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 创建订单
     *
     * @param userId
     * @param commodityId
     */
    @GetMapping("/createOrder")
    public Order createOrder(@RequestParam("userId") Integer userId,
                             @RequestParam("commodityId") Integer commodityId) {
        return orderService.createOrder(userId, commodityId);
    }

}
