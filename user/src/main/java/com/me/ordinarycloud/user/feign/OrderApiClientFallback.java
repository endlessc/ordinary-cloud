package com.me.ordinarycloud.user.feign;

import com.me.ordinarycloud.entity.Order;
import com.me.ordinarycloud.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderApiClientFallback implements OrderApiClient {

    @Override
    public List<Order> selectUserOrders(User user) {
        return null;
    }

}
