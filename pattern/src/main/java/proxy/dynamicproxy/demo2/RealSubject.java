package proxy.dynamicproxy.demo2;

/**
 * 被代理类,也就是真实的类,就类似于上述静态代理中的Seller类;
 */
public class RealSubject implements Subject {
    @Override
    public void action() {
        System.out.println("我是被代理类哦!!");
    }
}
