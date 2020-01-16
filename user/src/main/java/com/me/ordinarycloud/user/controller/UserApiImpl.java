package com.me.ordinarycloud.user.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.me.ordinarycloud.api.UserApi;
import com.me.ordinarycloud.entity.User;
import com.me.ordinarycloud.user.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserApiImpl implements UserApi {

    private final UserRepository userRepository;

    private final RedissonClient redissonClient;

    public UserApiImpl(UserRepository userRepository, RedissonClient redissonClient) {
        this.userRepository = userRepository;
        this.redissonClient = redissonClient;
    }

    @Override
    @LcnTransaction
    @Transactional
    public int updateUserBalance(@RequestBody User user) {

        String key = "user_stick_lock" + user.getUserId();

        RLock lock = redissonClient.getLock(key);
        try {
            // 获取锁
            lock.lock();
            // 剩余余额小于支付金额
            if (userRepository.selectUserBalance(user.getUserId()) < user.getUserBalance()) {
                return 0;
            }
            return userRepository.updateUserByUserId(user.getUserId(), user.getUserBalance());
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

}
