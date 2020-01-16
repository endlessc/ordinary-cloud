package com.me.ordinarycloud.user.dao;

public interface UserRepository {

    int updateUserByUserId(Integer userId, Double userBalance);

    Double selectUserBalance(Integer userId);
}
