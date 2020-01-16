package com.me.ordinarycloud.user.service;

import com.me.ordinarycloud.entity.Order;

import java.util.List;

public interface UserService {

    List<Order> selectUserOrders(Integer userId);

}
