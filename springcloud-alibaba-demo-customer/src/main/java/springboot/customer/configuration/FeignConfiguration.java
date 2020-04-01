package springboot.customer.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 如果加了@Configuration注解，
 * 就要将ProductorFeignConfiguration移动到Application的@Scan能扫描的路径以外，避免上下文重叠
 * 如果被扫描到那就是全局的
 */
//@Configuration
public class FeignConfiguration {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }

}
