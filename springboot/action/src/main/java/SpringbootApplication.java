import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("springboot.action.mvc.mapper")
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableWebSocket
@EnableSwagger2
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

//    public void addProperty(String[] args) {
//        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
//        // 设置初始化器
//        springApplication.addInitializers(new SecondInitializer());
//        // 设置监听器
//        springApplication.addListeners(new SecondListener());
//        // 设置属性
//        Properties properties = new Properties();
//        properties.setProperty("user", "cai");
//        springApplication.setDefaultProperties(properties);
//        springApplication.run(args);
//    }
//
//    public void publishEvent(String[] args) {
//        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
//        // 自定义监听器
//        springApplication.addListeners(new DiySpringBootListener());
//        ConfigurableApplicationContext context = springApplication.run(args);
//        context.publishEvent(new DiySpringBootEvent(new Object()));
//    }
//
//    public void testError() {
//        try {
//            throw new CException(new BException(new AException(new Exception("test"))));
//        } catch (Throwable t) {
//            while (t != null) {
//                System.out.println(t.getClass());
//                t = t.getCause();
//            }
//        }
//    }

}
