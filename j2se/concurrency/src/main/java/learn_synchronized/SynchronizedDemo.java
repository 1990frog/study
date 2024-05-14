package learn_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * synchronized
 *
 * 使用方式3种：
 * 1、同步代码块
 * 2、同步方法
 * 3、同步静态方法
 *
 * 锁的类型：
 * 1、对象锁
 * 2、类锁
 */
public class SynchronizedDemo {

    /**
     * 同步代码块 对象锁 或 类锁，取决于方法类型
     */
    public void block() {
        synchronized (this) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 同步方法，对象锁
     */
    public synchronized void method() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 同步静态方法，类锁
     */
    public static synchronized void staticMethod() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
