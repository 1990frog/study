package springboot.springboot.action;

import springboot.SpringbootApplication;
import springboot.action.aop.error.ThisErrorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootApplication.class)
public class Aop {

    @Autowired
    private ThisErrorController aop;

    @Test
    public void test(){
        aop.foo();
    }
}
