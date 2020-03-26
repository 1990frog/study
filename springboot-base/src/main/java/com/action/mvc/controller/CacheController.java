package com.action.mvc.controller;

import com.action.mvc.domain.entity.Product;
import com.action.mvc.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 多级缓存策略：
 * 1.先读本地缓存guava
 * 2.读redis
 * 3.读数据库
 */
@Controller
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/cache/query/{key}")
    @ResponseBody
    public Product query(@PathVariable("key")String key){
        Product product = (Product) cacheService.getCommonCache(key);

        if(product==null){
            product = (Product) redisTemplate.opsForValue().get(key);
            cacheService.setCommonCache(key,product);
        }

        return product;
    }
}
