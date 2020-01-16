package com.me.ordinarycloud.api;

import com.me.ordinarycloud.entity.Commodity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CommoditySelectApi {

    @RequestMapping(value = "/commodity/selectCommodityPrice", method = RequestMethod.POST)
    Double selectCommodityPrice(@RequestBody Commodity commodity);
}
