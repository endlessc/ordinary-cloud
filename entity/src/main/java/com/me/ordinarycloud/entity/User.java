package com.me.ordinarycloud.entity;

import lombok.Data;

@Data
public class User {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 余额
     */
    private Double userBalance;

}
