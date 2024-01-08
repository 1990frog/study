package dynamicproxy.jvm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StaticProxy {

    private BlackSoul game;

    /**
     * 静态代理的缺陷：
     * 增强方法与被代理的对象强耦合的
     */
    public void pay(){
        System.out.println("before");
        game.pay();
        System.out.println("after");
    }

}
