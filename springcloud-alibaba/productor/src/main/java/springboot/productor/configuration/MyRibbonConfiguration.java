package springboot.productor.configuration;

import springboot.ribbonconfiguration.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="user-center",configuration = RibbonConfiguration.class)
public class MyRibbonConfiguration {
}
