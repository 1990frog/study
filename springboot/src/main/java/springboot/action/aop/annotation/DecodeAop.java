package springboot.action.aop.annotation;

import springboot.action.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Slf4j
@Aspect
@Component
public class DecodeAop {

    @Pointcut("@annotation(springboot.action.aop.annotation.Decode)")
    public void decode(){
    }

    @Before("decode()")
    public void doBefore(JoinPoint joinPoint){
        log.info("Decode doBefore");
    }

    /**
     * ProceedingJoinPoint
     * JoinPoint
     */
    @After("decode()")
    public void doAfter(JoinPoint joinPoint){
        log.info("Decode doAfter");
        //获得执行方法的类名
        String targetName = joinPoint.getTarget().getClass().getName();
        //获得执行方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取切点方法的所有参数类型
        Object[] arguments = joinPoint.getArgs();



        log.info("Decode doAfter");
    }

//    @Around("decode()")
    public void doAround(ProceedingJoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            System.out.println("参数="+arg+" ");
//        }
//        try {
//            // 获取返回值
//            Result result= (Result) joinPoint.proceed();
//            Class clazz = result.getData().getClass();
//            Field[] fields = clazz.getDeclaredFields();
//
//            System.out.println(fields.length);
//
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }

    }

    @AfterReturning(value = "decode()",returning="ret")
    public void doAfterReturning(JoinPoint joinPoint,Object ret){
        Result result= (Result) ret;
        Class clazz = result.getData().getClass();
        Field[] fields = clazz.getDeclaredFields();

        System.out.println(fields.length);
    }


}
