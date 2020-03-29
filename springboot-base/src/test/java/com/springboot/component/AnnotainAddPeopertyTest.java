package com.springboot.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest("myarg:hello")
public class AnnotainAddPeopertyTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads(){
        System.out.println(applicationContext.getEnvironment().getProperty("myarg"));
    }
}
