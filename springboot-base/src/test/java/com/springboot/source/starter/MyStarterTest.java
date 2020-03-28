package com.springboot.source.starter;

import com.SpringbootApplication;
import com.component.condition.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = {SpringbootApplication.class})
public class MyStarterTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads(){
        System.out.println(applicationContext.getBean(A.class));
    }
}
