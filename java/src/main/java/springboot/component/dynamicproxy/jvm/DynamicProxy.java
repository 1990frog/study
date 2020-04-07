package springboot.component.dynamicproxy.jvm;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 */
@AllArgsConstructor
public class DynamicProxy implements InvocationHandler{

    private Object game;

    /**
     *
     * @param proxy 被代理的对象，通过强转，可以操作该对象
     * @param method 被代理的方法，通过反射invoke包裹对其增强
     * @param args 被代理的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("与被代理类无关，想做啥都行");
        return method.invoke(game,args);
    }

}

