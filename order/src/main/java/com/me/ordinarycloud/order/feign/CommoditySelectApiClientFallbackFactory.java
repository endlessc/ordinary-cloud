package com.me.ordinarycloud.order.feign;

import com.me.ordinarycloud.entity.Commodity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class CommoditySelectApiClientFallbackFactory implements FallbackFactory<CommoditySelectApiClient> {

    @Override
    public CommoditySelectApiClient create(Throwable cause) {
        return new CommoditySelectApiClient() {
            @Override
            public Double selectCommodityPrice(Commodity commodity) {
                return 0D;
            }
        };
    }

}
