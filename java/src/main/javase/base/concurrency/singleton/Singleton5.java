package javase.base.concurrency.singleton;

/**
 * 描述：
 * 懒汉式（线程不安全）（不推荐）
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            /**
             * 如果多个线程都运行到此位置，因为都跳过了null判断，所以会创建多个实例
             */
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
