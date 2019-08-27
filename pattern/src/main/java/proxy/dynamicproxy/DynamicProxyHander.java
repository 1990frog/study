package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class DynamicProxyHander implements InvocationHandler {
    // 被代理类,将其作为实例变量在构造函数中传入
    private Object proxied;

    public DynamicProxyHander(Object proxied) {
        this.proxied = proxied;
    }

    /**
     *
     * @param proxy 自定义的代理
     * @param method 方法
     * @param args 参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*****　proxy: " + proxy.getClass().getSimpleName() + "method :" + method + "args: " + args);
        /**
         * 代理调用方法
         */
        return method.invoke(proxied, args);
    }

}