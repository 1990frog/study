/**
 * 静态内部类
 *
 * 用 static 修饰内部类，称为静态内部类，完全属于外部类本身，不属于外部类的一个对象，外部类不可以定义为静态类，Java 中静态类只有一种，那就是静态内部类
 *
 * 核心：
 * 1、静态内部类在外部类装载的时候并不会执行，也就是满足了 lazy loading；
 * 2、调用 getInstance 方法的时候会取属性，此时才加载静态内部类，而 JVM 底层的类装载机制是线程安全的，所以利用 JVM 达到了我们要的线程安全；
 * 3、类的静态属性保证了实例化也只会运行一次，满足单例。
 *
 */
public class StaticInnerClassSingleton {

    // 私有构造器
    private StaticInnerClassSingleton() {
    }

    // 一个静态内部类，里面有一个静态属性，就是实例
    private static class SingletonInstance {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    // 静态的公有方法
    public static StaticInnerClassSingleton getInstance() {
        return SingletonInstance.instance;
    }
}
