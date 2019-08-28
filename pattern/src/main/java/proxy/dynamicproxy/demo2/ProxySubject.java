package proxy.dynamicproxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类,也就是代理对象,就类似于上述静态代理中的Scalper类;
 */
class ProxySubject implements InvocationHandler { // 涉及到动态代理需要实现这个接口InvocationHandler

    // 实现了接口的被代理类的对象引用声明;
    private Object object;

    public Object getNewInstance(Object object) {
        // 实例化被代理类的对象;
        this.object = object;
        // 返回一个代理类的对象;
        /**
         * 这里的newProxyInstance的三个参数:(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
         *      1.第一个参数是需要传入类的加载器,这里指的是被代理类的类加载器,简单来说就是和被代理类使用相同的类加载器;
         *      2.第二个参数是需要传入类的接口,也就是说,这个类实现了哪些接口,我都要传过来;
         *      3.第三个参数是需要传入的一个InvocationHandler对象,指的是代理类对象,也就是调用这个函数的this对象(ProxySubject对象);
         */
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    // 当通过代理类的对象发起对被重写的方法的调用是,都会转换为对以下invoke方法的调用;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 增强代码(前);
        System.out.println("前增强功能!!");

        // 被代理类的方法;
        Object value = method.invoke(object, args);

        // 增强代码(后);
        System.out.println("后增强功能!!");
        return value;
    }
}
