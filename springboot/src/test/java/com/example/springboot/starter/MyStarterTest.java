package com.example.springboot.starter;

import com.SpringbootApplication;
import com.condi.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootApplication.class})
public class MyStarterTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads(){
        System.out.println(applicationContext.getBean(A.class));
    }
}
