package base.concurrency.moocwukong.core.singleton;

/**
 * 描述：
 * 饿汉式（静态常量）（可用）
 *
 * 优点：
 * 1）简单
 * 2）类加载时初始化单例
 *
 * 饿汉：
 * 在类加载的时候就创建了对象，急不可耐
 *
 * 懒汉：
 * 在需要用到的时候，加载单例（可能线程不安全）
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    /**
     * 单例模式的构造函数都是私有的，因为我们不希望外界创建新的对象，而是复用已存在的对象
     */
    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
