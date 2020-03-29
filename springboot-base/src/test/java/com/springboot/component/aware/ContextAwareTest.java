package com.springboot.component.aware;

import com.SpringbootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;


@SpringBootTest(classes = {SpringbootApplication.class})
public class ContextAwareTest implements EnvironmentAware, BeanNameAware {

    private Environment environment;

    private String beanName;

    @Test
    public void contextLoads(){
        System.out.println(environment.getProperty("hello"));
        System.out.println(beanName);
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
