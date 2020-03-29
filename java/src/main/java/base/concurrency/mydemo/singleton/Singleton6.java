package base.concurrency.mydemo.singleton;

/**
 * 描述：
 * 双重检查（推荐面试使用）
 *
 * 优点：线程安全；延迟加载；效率较高
 *
 * 为什么要用volatile？
 * 1.新建对象实际上有3个步骤
 *
 */
public class Singleton6 {

    private volatile static Singleton6 instance;

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
