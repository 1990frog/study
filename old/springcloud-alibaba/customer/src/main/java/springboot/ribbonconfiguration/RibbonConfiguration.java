package springboot.ribbonconfiguration;

import com.netflix.loadbalancer.DummyPing;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.ribbonconfiguration.ribbonrule.SelectPortRule;

@Configuration
public class RibbonConfiguration {

//    @Bean
//    public ILoadBalancer myLoadBalancer(){
//        return new ZoneAwareLoadBalancer();
//    }

    /**
     * 负载均衡规则
     * @return
     */
    @Bean
    public IRule myRule(){
//        return new RandomRule();
//        return new RoundRobinRule();
        return new SelectPortRule();
    }

    @Bean
    public IPing myPing(){
        return new DummyPing();
    }

}
