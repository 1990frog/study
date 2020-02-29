package com;

import com.except.AException;
import com.except.BException;
import com.except.CException;
import com.initializer.SecondInitializer;
import com.listener.DiySpringBootEvent;
import com.listener.DiySpringBootListener;
import com.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@SpringBootApplication
@PropertySource({"demo.properties"})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    public void addProperty(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
        // 设置初始化器
        springApplication.addInitializers(new SecondInitializer());
        // 设置监听器
        springApplication.addListeners(new SecondListener());
        // 设置属性
        Properties properties = new Properties();
        properties.setProperty("user", "cai");
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }

    public void publishEvent(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
        // 自定义监听器
        springApplication.addListeners(new DiySpringBootListener());
        ConfigurableApplicationContext context = springApplication.run(args);
        context.publishEvent(new DiySpringBootEvent(new Object()));
    }

    public void testError() {
        try {
            throw new CException(new BException(new AException(new Exception("test"))));
        } catch (Throwable t) {
            while (t != null) {
                System.out.println(t.getClass());
                t = t.getCause();
            }
        }
    }

}
