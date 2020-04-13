package javase.base.reflection.dynamicproxy.jvm;

import java.lang.reflect.Proxy;

public class App {

    private static BlackSoul blackSoul = new BlackSoul();

    public static Object getDynamicProxy(Object obj){
        return Proxy.newProxyInstance(
                /**
                 * 一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
                 */
                BlackSoul.class.getClassLoader(),
                /**
                 * 一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
                 */
                new Class[]{Game.class,Sales.class},
                /**
                 * 一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
                 */
                new DynamicProxy(obj));
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        /**
         * 静态代理
         */
        StaticProxy staticProxy = new StaticProxy(blackSoul);
        staticProxy.pay();
        /**
         * JDK代理只能只针对接口来产生代理,代理类与被代理类类似兄弟关系  不能相互转换 只能用共同的接口
         */
        Game game = (Game)getDynamicProxy(blackSoul);
        game.play();
        game.display();
//        game.difficulty();
        Sales sales = (Sales)getDynamicProxy(blackSoul);
        sales.pay();
    }

}
