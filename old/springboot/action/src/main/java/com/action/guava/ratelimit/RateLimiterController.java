package com.action.guava.ratelimit;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@Slf4j
@Controller
public class RateLimiterController {

    private RateLimiter rateLimiter;

    @PostConstruct
    public void init(){
        //创建一个限流器，参数代表每秒生成的令牌数
        rateLimiter = RateLimiter.create(1);
        //创建一个限流器，参数代表每秒生成的令牌数,超时时间
//        rateLimiter = RateLimiter.create(5,5, TimeUnit.SECONDS);
    }

    @GetMapping("/ratelimiter/acquire")
    public String acquire(){
        double waitTime = rateLimiter.acquire();
        System.out.println("cutTime=" + System.currentTimeMillis() + " waitTime:" + waitTime);
        return "";
    }
}
