package com.me.ordinarycloud.api;

import com.me.ordinarycloud.entity.Order;
import com.me.ordinarycloud.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface OrderApi {

    @RequestMapping(value = "/order/userOrders", method = RequestMethod.POST)
    List<Order> selectUserOrders(@RequestBody User user);

}
