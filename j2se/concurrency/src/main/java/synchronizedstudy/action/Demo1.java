package synchronizedstudy.action;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 两个线程同时访问一个对象的同步方法
 * 此时两个线程争抢同一把锁，故线程为串行执行
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/8
 */
@Slf4j
public class Demo1 implements Runnable {

    static Demo1 instance = new Demo1();

    public static void main(String[] args) throws InterruptedException {
        log.info("{} 运行开始！", Thread.currentThread().getName());
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("{} 运行结束！", Thread.currentThread().getName());
    }

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void method() throws InterruptedException {
        log.info("{} 运行开始！", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
        log.info("{} 运行结束！", Thread.currentThread().getName());
    }
}
