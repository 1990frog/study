package action.aop.error;


import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
public class ThisErrorController {

    @Autowired
    private ApplicationContext applicationContext;

    public void foo(){
        log.info("hello");
        // error
        bar();
        // 解决方案1
        ((ThisErrorController)AopContext.currentProxy()).bar();
        // 解决方案2
        applicationContext.getBean(this.getClass()).bar();
    }

    public void bar(){
        log.info("normal");
    }

}