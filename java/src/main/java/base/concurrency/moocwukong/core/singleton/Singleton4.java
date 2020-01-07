package base.concurrency.moocwukong.core.singleton;

/**
 * 描述：
 * 懒汉式（线程安全）（不推荐）
 *
 * 使用synchronized，会产生竞争，效率低（互斥）
 * 例子：
 * 多个线程同时想要处理一个字符串，因为同步，所以不可能同时拿到业务对象的实例，也就不可能同时处理
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {

    }

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
