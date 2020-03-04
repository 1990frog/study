package com.ribbonconfiguration;

import com.nacos.configuration.NacosWeightedRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
//        return new RandomRule();
        // 自定义rule
        return new NacosWeightedRule();
    }

    @Bean
    public IPing ping(){
        return new PingUrl();
    }
}
