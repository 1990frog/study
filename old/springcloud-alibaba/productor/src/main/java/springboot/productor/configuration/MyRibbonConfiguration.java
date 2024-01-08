package springboot.productor.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import springboot.ribbonconfiguration.RibbonConfiguration;

@Configuration
@RibbonClient(name="user-center",configuration = RibbonConfiguration.class)
public class MyRibbonConfiguration {
}
