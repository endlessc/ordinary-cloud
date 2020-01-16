package com.me.ordinarycloud.order.feign;

import com.me.ordinarycloud.api.UserApi;
import com.me.ordinarycloud.common.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user", configuration = FeignConfiguration.class)
public interface UserApiClient extends UserApi {
}
