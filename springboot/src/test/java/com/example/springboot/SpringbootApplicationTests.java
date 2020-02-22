package com.example.springboot;

import com.ioc.xml.App;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(locations = "classpath:ioc/demo.xml")
class SpringbootApplicationTests {

    @Autowired
    private App app;

    @Test
    void contextLoads() {
        System.out.println(app.hello());
    }

}
