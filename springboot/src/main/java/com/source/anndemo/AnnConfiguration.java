package com.source.anndemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class AnnConfiguration {

//    @Bean
//    public DemoEntry demoEntry() {
//        return new DemoEntry();
//    }

    @Bean("userMap")
    public HashMap diMap(){
        return new HashMap(){
            {
                put("xiaoming",'1');
                put("xiaohong",'2');
            }
        };
    }
}
