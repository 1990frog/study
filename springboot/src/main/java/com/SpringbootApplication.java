package com;

import com.initializer.SecondInitializer;
import com.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootApplication.class, args);

        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
        springApplication.addInitializers(new SecondInitializer());
        springApplication.addListeners(new SecondListener());
        springApplication.run(args);
    }

}
