package com.me.ordinarycloud.order.feign;

import com.me.ordinarycloud.entity.Commodity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CommodityApiClientFallbackFactory implements FallbackFactory<CommodityApiClient> {

    @Override
    public CommodityApiClient create(Throwable cause) {
        return new CommodityApiClient() {
            @Override
            public int updateCommodityStock(Commodity commodity) {
                return 0;
            }
        };
    }
}
