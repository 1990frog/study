package com.action.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 记录异常日志
 * 不使用@ControllerAdvice与@ExceptionHandler是为了更详细的记录日志信息（用户信息，class信息，object信息）
 */
@Component
@Aspect
@Slf4j
public class LogbackAspect {

//    @AfterThrowing(pointcut = "within(com.action.mvc.controller.*)", throwing = "ex")
    @AfterThrowing(pointcut = "within(com.*)", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex) throws Exception {
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        String clazz = declaringType.getCanonicalName();
        String name = joinPoint.getSignature().getName();
        if (ex instanceof BusinessException) {
            log.warn("class:{},name:{}", clazz, name, ex);
        } else {
            log.error("class:{},name:{}", clazz, name, ex);
        }
        throw ex;
    }
}
