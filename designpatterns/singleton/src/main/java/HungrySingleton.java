/**
 * 懒汉式单例模式
 * <p>
 * 饿汉式的实现方式比较简单。在类加载的时候，instance 静态实例就已经创建并初始化好了，所以，instance 实例的创建过程是线程安全的。不过，这样的实现方式不支持延迟加载。
 *
 * 优势：
 * 线程安全
 *
 * 缺点：
 * 不支持延迟加载
 */
public class HungrySingleton {

    // 私有构造器，避免类被创建
    private HungrySingleton() {

    }

    // 类加载时创建对象
    private static final HungrySingleton instance = new HungrySingleton();

    // 静态工厂方法，返回实例
    public static HungrySingleton getInstance() {
        return instance;
    }
}
