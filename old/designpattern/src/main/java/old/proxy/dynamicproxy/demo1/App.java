package old.proxy.dynamicproxy.demo1;

import java.lang.reflect.Proxy;

public class App {

    public static void consume(DoSomething doSomething){
        doSomething.doSomething();
        doSomething.doSomethingElse("bonbo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consume(real);
        DoSomething proxy = (DoSomething) Proxy.newProxyInstance(DoSomething.class.getClassLoader(),
                new Class[]{DoSomething.class}, new DynamicProxyHander(real));
        consume(proxy);
    }
}