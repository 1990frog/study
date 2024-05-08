package synchronizedstudy.action;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 同时访问静态synchronized和非静态synchronized方法
 * 这两个方法可以并行执行.静态加锁的方法的锁是class对象，非静态加锁的方法的锁对象是this对象.这两个方法不是争抢同一把锁
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/8
 */
@Slf4j
public class Demo6 implements Runnable {

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            method1();
        } else {
            method2();
        }
    }

    @SneakyThrows
    public static synchronized void method1() {
        log.info("{} 开始调用静态同步方法！", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        log.info("{} 结束调用静态同步方法！", Thread.currentThread().getName());
    }

    @SneakyThrows
    public synchronized void method2() {
        log.info("{} 开始调用同步方法！", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(10);
        log.info("{} 结束调用同步方法！", Thread.currentThread().getName());
    }

    @SneakyThrows
    public static void main(String[] args) {
        Runnable runnable = new Demo6();
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("finish!");
    }
}
