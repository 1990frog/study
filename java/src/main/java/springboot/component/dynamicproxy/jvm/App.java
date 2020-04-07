package springboot.component.dynamicproxy.jvm;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class App {

    private BlackSoul blackSoul = new BlackSoul();

    /**
     * 动态代理
     */
    @Test
    public void dynamicProxy(){
        Game proxy = (Game) Proxy.newProxyInstance(
                /**
                 * 一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
                 * 这里使用Game与BlackSoul都可以
                 * BlackSoul更好，因为后面还要传个Interface数组，传Game可能比较片面
                 */
                BlackSoul.class.getClassLoader(),
                /**
                 * 一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
                 */
                new Class[]{Game.class},
                /**
                 * 一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
                 */
                new DynamicProxy(blackSoul));
        proxy.play();
        proxy.pay();
    }

    /**
     * 静态代理
     */
    @Test
    public void staticProxy(){
        StaticProxy staticProxy = new StaticProxy(blackSoul);
        staticProxy.pay();
    }

}
