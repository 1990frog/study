package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.integration.redis.util.RedisLockRegistry;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory factory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        // key序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value序列化方式
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // hashkey序列化方式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // hashvalue序列化方式
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        // 注入连接工厂
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    /**
     * redis分布式锁
     */
    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockRegistry(redisConnectionFactory, "springboot");
    }
}
