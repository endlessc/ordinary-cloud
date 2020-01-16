package com.me.ordinarycloud.commodity.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommodityRepositoryImpl implements CommodityRepository {

    private final JdbcTemplate jdbcTemplate;

    public CommodityRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int updateCommodityByCommodityId(Integer commodityId, Integer commodityStock) {

        String sql = "update tb_commodity set commodity_stock=commodity_stock-? where commodity_id=?";
        int res = jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setInt(1, commodityStock);
            preparedStatement.setInt(2, commodityId);
        });
        return res;
    }

    @Override
    public Double selectCommodityPrice(Integer commodityId) {
        String sql = "SELECT commodity_price FROM tb_commodity WHERE commodity_id = " + commodityId;
        return jdbcTemplate.queryForObject(sql, Double.class);
    }

    @Override
    public Integer selectCommodityStock(Integer commodityId) {
        String sql = "SELECT commodity_stock FROM tb_commodity WHERE commodity_id = " + commodityId;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
