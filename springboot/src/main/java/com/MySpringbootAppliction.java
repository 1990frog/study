package com;

import com.source.except.AException;
import com.source.except.BException;
import com.source.except.CException;
import com.source.initializer.SecondInitializer;
import com.source.listener.DiySpringBootEvent;
import com.source.listener.DiySpringBootListener;
import com.source.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class MySpringbootAppliction {

    public static void main(String[] args) {
        new MySpringbootAppliction().addProperty(args);
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
