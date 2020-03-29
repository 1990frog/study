package com.springboot.component.config;

import com.SpringbootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = {SpringbootApplication.class})
@ContextConfiguration(locations = "classpath:ioc/demo.xml")
public class ContextConfigurationTest {

    @Test
    void contextLoads(){

    }
}
