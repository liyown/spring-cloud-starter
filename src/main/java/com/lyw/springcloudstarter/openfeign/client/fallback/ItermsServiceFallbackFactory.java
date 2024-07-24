package com.lyw.springcloudstarter.openfeign.client.fallback;

import com.lyw.springcloudstarter.openfeign.client.ItemDTO;
import com.lyw.springcloudstarter.openfeign.client.ItermService;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author: liuyaowen
 * @poject: hmall
 * @create: 2024-07-11 13:39
 * @Description: fallback factory example
 */
public class ItermsServiceFallbackFactory implements FallbackFactory<ItermService> {

    @Override
    public ItermService create(Throwable throwable) {
        System.out.println("fallbackFactory");
        return new ItermService() {
            @Override
            public List<ItemDTO> queryItermByIDs(Collection<Long> ids) {
                System.out.println("fallback");
                throw new RuntimeException("远程调用失败");
            }

            @Override
            public void deductStock(List<Map<String, Object>> items) {
                throw new RuntimeException("远程调用失败");
            }

            @Override
            public void updateItem(ItemDTO item) {
                throw new RuntimeException("远程调用失败");
            }
        };
    }
}
