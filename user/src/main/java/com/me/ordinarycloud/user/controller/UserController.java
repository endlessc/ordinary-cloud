package com.me.ordinarycloud.user.controller;

import com.me.ordinarycloud.entity.Order;
import com.me.ordinarycloud.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RefreshScope   // 支持手动刷新
@RequestMapping("/user")
public class UserController {

    @Value("${age}")
    private Integer age;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取莫用户全部订单
     *
     * @param userId
     * @return
     */
    @GetMapping("/selectUserOrders")
    public List<Order> selectUserOrders(Integer userId) {
        System.out.println("age:" + age);
        return userService.selectUserOrders(userId);
    }

    /**
     * 测试configClient
     *
     * @return
     */
    @GetMapping("/configClientTest")
    public Integer configClientTest() {
        return age;
    }

}
