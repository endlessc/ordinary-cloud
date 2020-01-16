package com.me.ordinarycloud.user.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int updateUserByUserId(Integer userId, Double userBalance) {

        String sql = "update tb_user set user_balance=user_balance-? where user_id=?";
        int res = jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setDouble(1, userBalance);
            preparedStatement.setInt(2, userId);
        });
        return res;
    }

    @Override
    public Double selectUserBalance(Integer userId) {
        String sql = "SELECT user_balance FROM tb_user WHERE user_id = " + userId;
        return jdbcTemplate.queryForObject(sql, Double.class);
    }

}
