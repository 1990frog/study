package com.example.mystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MystarterSource.class)
@ConditionalOnProperty(name="mystarter.enable",havingValue = "enable")
public class MystarterAutoConfiguration {

    @Autowired
    private MystarterSource source;

    @Bean
    @ConditionalOnMissingBean(MystarterServrice.class)
    public MystarterServrice mystarterServrice(){
        return new MystarterServrice(source);
    }
}
