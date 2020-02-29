package com.example.springboot;

import com.SpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
