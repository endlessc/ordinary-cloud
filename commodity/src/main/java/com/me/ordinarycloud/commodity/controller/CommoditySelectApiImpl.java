package com.me.ordinarycloud.commodity.controller;

import com.me.ordinarycloud.api.CommoditySelectApi;
import com.me.ordinarycloud.commodity.dao.CommodityRepository;
import com.me.ordinarycloud.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CommoditySelectApiImpl implements CommoditySelectApi {

    private final CommodityRepository commodityRepository;

    public CommoditySelectApiImpl(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public Double selectCommodityPrice(Commodity commodity) {
        return commodityRepository.selectCommodityPrice(commodity.getCommodityId());
    }

}
