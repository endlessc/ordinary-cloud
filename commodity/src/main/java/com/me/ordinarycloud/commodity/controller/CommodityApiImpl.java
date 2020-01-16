package com.me.ordinarycloud.commodity.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.me.ordinarycloud.api.CommodityApi;
import com.me.ordinarycloud.commodity.dao.CommodityRepository;
import com.me.ordinarycloud.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CommodityApiImpl implements CommodityApi {

    private final CommodityRepository commodityRepository;

    private final RedissonClient redissonClient;

    public CommodityApiImpl(CommodityRepository commodityRepository, RedissonClient redissonClient) {
        this.commodityRepository = commodityRepository;
        this.redissonClient = redissonClient;
    }

    @Override
    @LcnTransaction
    @Transactional
    public int updateCommodityStock(@RequestBody Commodity commodity) {

        String key = "commodity_stick_lock" + commodity.getCommodityId();

        RLock lock = redissonClient.getLock(key);
        try {
            // 获取锁
            lock.lock();
            // 剩余库存小于需要购买的数量
            if (commodityRepository.selectCommodityStock(commodity.getCommodityId()) < commodity.getCommodityStock()) {
                return 0;
            }
            return commodityRepository.updateCommodityByCommodityId(commodity.getCommodityId(), commodity.getCommodityStock());
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

}
