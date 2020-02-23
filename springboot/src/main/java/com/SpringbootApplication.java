package com;

import com.initializer.SecondInitializer;
import com.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@SpringBootApplication
@PropertySource({"demo.properties"})
public class SpringbootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootApplication.class, args);

        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
        springApplication.addInitializers(new SecondInitializer());
        springApplication.addListeners(new SecondListener());

        // 设置属性
        Properties properties = new Properties();
        properties.setProperty("user","cai");
        springApplication.setDefaultProperties(properties);

        // 运行
        springApplication.run(args);

    }

}
