package com.customer.feignclient;

import com.customer.configuration.GlobalFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

/**
 * productor对应的feign
 */
//@FeignClient(name = "productor",configuration = GlobalFeignConfiguration.class)
@FeignClient(name = "productor")
public interface ProductorFeignClient {

    @GetMapping("/productor")
    String queryProduct();
}
