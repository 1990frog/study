package com.customer.configuration;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration {

    /**
     * 负载均衡规则
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }


}
