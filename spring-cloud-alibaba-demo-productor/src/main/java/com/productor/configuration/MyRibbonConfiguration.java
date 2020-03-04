package com.productor.configuration;

import com.ribbonconfiguration.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="user-center",configuration = RibbonConfiguration.class)
public class MyRibbonConfiguration {
}
