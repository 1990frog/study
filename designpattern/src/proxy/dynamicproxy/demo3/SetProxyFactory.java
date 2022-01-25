package proxy.dynamicproxy.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

/**
 * SetProxyFactory 类包含一个静态工厂方法 getSetProxy()，它返回一个实现了 Set 的动态代理。
 * 代理对象实际实现 Set —— 调用者无法区分（除非通过反射）返回的对象是动态代理。
 * SetProxyFactory 返回的代理只做一件事，把方法分派给传递给工厂方法的 Set 实例。
 * 虽然反射代码通常比较难读，但是这里的内容很少，跟上控制流程并不难 ——只要某个方法在 Set 代理上被调用，
 * 它就被分派给调用句柄，调用句柄只是反射地调用底层包装的对象上的目标方法。当然，绝对什么都不做的代理可能有点傻，是不是呢？
 */
public class SetProxyFactory {

    public static Set getSetProxy(final Set s) {

        return (Set) Proxy.newProxyInstance(
                s.getClass().getClassLoader(), new Class[]{Set.class}, new InvocationHandler() {
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        return method.invoke(s, args);
                    }
                }
        );
    }
}
