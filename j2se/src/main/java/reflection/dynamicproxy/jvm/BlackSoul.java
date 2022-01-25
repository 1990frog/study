package reflection.dynamicproxy.jvm;

/**
 * 被代理类
 */
public class BlackSoul implements Game,Sales {
    @Override
    public void pay() {
        System.out.println("$60");
    }

    @Override
    public void play() {
        System.out.println("dead dead dead");
    }

    public static void staticMehtod(){
        System.out.println("不能代理静态方法");
    }

}
