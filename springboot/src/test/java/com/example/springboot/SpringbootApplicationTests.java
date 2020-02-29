package com.example.springboot;

import com.SpringbootApplication;
import com.aware.Flag;
import com.aware.MyAware;
import com.condi.A;
import com.ioc.xml.App;
import com.mvc.controller.DemoController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest("condition:dudu")
//@SpringBootTest("test:dudu")
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {SpringBootApplication.class})
@ContextConfiguration(locations = "classpath:ioc/demo.xml")

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootApplication.class})
class SpringbootApplicationTests implements EnvironmentAware, BeanNameAware, MyAware {

    @Autowired
    private App app;

    private Environment env;

    private Flag flag;

    @Autowired
    private ApplicationContext applicationContext;

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

    @Override
    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    @Test
    void testMyAware(){
        System.out.println(flag.isCanOperate());
    }

    @Test
    public void testA(){
        System.out.println(applicationContext.getBean(A.class));
    }
}
