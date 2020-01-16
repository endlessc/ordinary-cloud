package com.me.ordinarycloud.api;

import com.me.ordinarycloud.entity.Commodity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CommodityApi {

    @RequestMapping(value = "/commodity/updateCommodityStock", method = RequestMethod.POST)
    int updateCommodityStock(@RequestBody Commodity commodity);

}
