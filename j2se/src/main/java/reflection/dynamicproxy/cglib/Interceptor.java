package reflection.dynamicproxy.cglib;

import javase.base.reflection.dynamicproxy.jvm.BlackSoul;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Interceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object ret = methodProxy.invokeSuper(o,objects);
        System.out.println("after");
        return ret;
    }

    public static void main(String[] args) {
        Enhancer eh = new Enhancer();
        eh.setSuperclass(BlackSoul.class);
        eh.setCallback(new Interceptor());

        BlackSoul blackSoul = (BlackSoul)eh.create();
        blackSoul.pay();
        blackSoul.play();
    }
}
