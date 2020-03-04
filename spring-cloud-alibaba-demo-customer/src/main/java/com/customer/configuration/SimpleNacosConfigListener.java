package com.customer.configuration;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class SimpleNacosConfigListener {

//    public static final String PROPERTIES_DATA_ID = "properties-data-id";
//    public static final String DEFAULT_GROUP = "SB";
//
//    @NacosInjected
//    private ConfigService configService;
//
//    @PostConstruct
//    public void init() throws Exception {
//        // Build Properties Content
//        StringBuilder builder = new StringBuilder();
//        builder.append("user.id = 1");
//        builder.append("user.name = mercyblitz");
//        configService.publishConfig(PROPERTIES_DATA_ID, DEFAULT_GROUP,
//                builder.toString());
//    }
//
//    @NacosConfigListener(dataId = PROPERTIES_DATA_ID)
//    public void onReceived(String value) {
//        log.info("onReceived(String) : {}", value);
//    }
}