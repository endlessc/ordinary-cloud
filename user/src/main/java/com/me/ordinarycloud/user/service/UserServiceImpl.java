package com.me.ordinarycloud.user.service;

import com.me.ordinarycloud.entity.Order;
import com.me.ordinarycloud.entity.User;
import com.me.ordinarycloud.user.feign.OrderApiClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final OrderApiClient orderApiClient;

    public UserServiceImpl(OrderApiClient orderApiClient) {
        this.orderApiClient = orderApiClient;
    }

    @Override
    public List<Order> selectUserOrders(Integer userId) {
        User user = new User();
        user.setUserId(userId);
        return orderApiClient.selectUserOrders(user);
    }

}
