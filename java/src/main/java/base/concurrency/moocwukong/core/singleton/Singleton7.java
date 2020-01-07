package base.concurrency.moocwukong.core.singleton;

/**
 * 描述：
 * 静态内部类方式，可用
 *
 * 懒汉
 * 单例实例化的语句放到了内部类中，这样一来，在外部类的加载过程中，
 * 按照JVM的规定是不会直接把内部类里面的实例初始化的，这也意味着饿汉的的缺点不在存在了，
 * 我们实现的是懒汉的行为，只有当需要这个实例的时候才会初始化，也不会创建多个实例（JVM保证的）
 * 保证了线程安全与懒加载
 */
public class Singleton7 {

    private Singleton7() {

    }

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }


    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
