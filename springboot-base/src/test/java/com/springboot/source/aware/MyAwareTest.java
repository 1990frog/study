package com.springboot.source.aware;

import com.SpringbootApplication;
import com.sourcecode.aware.Flag;
import com.sourcecode.aware.MyAware;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest(classes = {SpringbootApplication.class})
@PropertySource({"demo.properties"})
public class MyAwareTest implements MyAware {

    private Flag flag;

    @Override
    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    @Test
    public void contextLoads(){
        System.out.println(flag.toString());
    }
}
