package proxy.dynamicproxy.demo2;

import proxy.staticproxy.demo3.Seller;
import proxy.staticproxy.demo3.Worker;

public class App {

    public static void main(String[] args){
        // 1.创建被代理类对象;
        RealSubject realSubject = new RealSubject();
        // 2.创建一个实现了InvocationHandler接口的类的对象;
        ProxySubject proxySubject = new ProxySubject();
        // 3.父类引用指向子类对象;
        Subject subject = (Subject)proxySubject.getNewInstance(realSubject);
        // 4.执行代理类的方法;
        subject.action();

        // 使用前面静态代理的例子,创建一个Seller的被代理类对象;
        Seller seller = new Seller();
        // 创建一个Worker的子类对象,指向Seller的代理类对象;
        Worker worker = (Worker)proxySubject.getNewInstance(seller);
        // 执行其方法;
        worker.sell();
    }

}
