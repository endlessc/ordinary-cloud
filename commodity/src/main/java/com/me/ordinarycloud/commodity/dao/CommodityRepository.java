package com.me.ordinarycloud.commodity.dao;

public interface CommodityRepository {

    int updateCommodityByCommodityId(Integer commodityId, Integer commodityStock);

    Double selectCommodityPrice(Integer commodityId);

    Integer selectCommodityStock(Integer commodityId);
}
