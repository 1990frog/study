package com.customer;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.customer.rocketmq.MySink;
import com.customer.rocketmq.MySource;
import com.ribbonconfiguration.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
//@EnableFeignClients(defaultConfiguration = ProductorFeignConfiguration.class)
@EnableFeignClients
@EnableBinding({Source.class, Sink.class, MySource.class, MySink.class})
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    @SentinelRestTemplate
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
