package com.me.ordinarycloud.user.feign;

import com.me.ordinarycloud.api.OrderApi;
import com.me.ordinarycloud.common.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order", configuration = FeignConfiguration.class, fallback = OrderApiClientFallback.class)
public interface OrderApiClient extends OrderApi {
}
