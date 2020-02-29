package com.example.springboot;

import com.SpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootApplication.class})
@ContextConfiguration(locations = "classpath:ioc/demo.xml")
public class ContextConfigurationTest {

    @Test
    void contextLoads(){

    }
}
