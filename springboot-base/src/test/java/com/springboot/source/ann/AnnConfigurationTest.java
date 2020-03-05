package com.springboot.source.ann;

import com.SpringbootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.HashMap;

@SpringBootTest(classes = {SpringbootApplication.class})
public class AnnConfigurationTest {

//    @Autowired
//    @Qualifier("demo")
//    private DemoEntry demoEntry;

    @Autowired
    @Qualifier("userMap")
    private HashMap userMap;

    @Test
    public void contextLoad(){
//        demoEntry.print();

        userMap.entrySet().stream().forEach(n-> System.out.println(n));
    }
}
