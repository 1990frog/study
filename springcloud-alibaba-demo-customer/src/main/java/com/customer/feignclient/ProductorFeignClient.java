package com.customer.feignclient;

import com.customer.configuration.GlobalFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@FeignClient(name = "productor",configuration = GlobalFeignConfiguration.class)
public interface ProductorFeignClient {

    @GetMapping("/productor/{id}")
    HashMap queryProduct(@PathVariable("id")String id);
}
