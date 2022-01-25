package reflection.dynamicproxy.jvm;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 不在关注具体被代理的类
 * 只需要设定一种对代理类的增强
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
        System.out.println("before");
        Object object = method.invoke(game,args);
        System.out.println("after");
        return object;
    }

}

