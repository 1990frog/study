package com.example.springboot;

import com.ioc.xml.App;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest("test:dudu")
@ContextConfiguration(locations = "classpath:ioc/demo.xml")
class SpringbootApplicationTests implements EnvironmentAware, BeanNameAware {

    @Autowired
    private App app;

    private Environment env;

    @Test
    void contextLoads() {
        System.out.println(app.hello());
    }

    @Test
    void testProperties(){
        System.out.println(env.getProperty("test"));
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Override
    public void setBeanName(String name) {

    }
}
