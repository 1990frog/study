package com.example.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("myarg:hello")
public class AnnotainAddPeopertyTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads(){
        System.out.println(applicationContext.getEnvironment().getProperty("myarg"));
    }
}
