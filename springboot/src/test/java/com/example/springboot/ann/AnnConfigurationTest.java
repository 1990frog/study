package com.example.springboot.ann;

import com.SpringbootApplication;
import com.entry.DemoEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootApplication.class})
public class AnnConfigurationTest {

    @Autowired
    @Qualifier("demo")
    private DemoEntry demoEntry;

    @Autowired
    @Qualifier("userMap")
    private HashMap userMap;

    @Test
    public void contextLoad(){
        demoEntry.print();

        userMap.entrySet().stream().forEach(n-> System.out.println(n));
    }
}
