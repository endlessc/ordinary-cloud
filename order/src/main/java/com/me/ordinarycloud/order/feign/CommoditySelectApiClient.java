package com.me.ordinarycloud.order.feign;

import com.me.ordinarycloud.api.CommoditySelectApi;
import com.me.ordinarycloud.common.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "commodity", configuration = FeignConfiguration.class, fallbackFactory = CommoditySelectApiClientFallbackFactory.class)
public interface CommoditySelectApiClient extends CommoditySelectApi {
}
