package com.me.ordinarycloud.order.feign;

import com.me.ordinarycloud.api.CommodityApi;
import com.me.ordinarycloud.common.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "commodity", configuration = FeignConfiguration.class, fallbackFactory = CommodityApiClientFallbackFactory.class)
public interface CommodityApiClient extends CommodityApi {
}
