package com.action.aop.error;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ThisErrorAop {

    /**
     * 定义切点：如果有此注解的地方
     */
    @Pointcut("execution(public * com.action.aop.error.ThisErrorController.*())")
    public void serviceAspect() {
    }

    @Before(value = "serviceAspect()")
    public void before(){
        log.info("===before===");
    }

    @After(value = "serviceAspect()")
    public void after(){
        log.info("===after===");
    }
}
