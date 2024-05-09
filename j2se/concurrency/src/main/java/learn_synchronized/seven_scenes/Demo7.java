package learn_synchronized.seven_scenes;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 方法抛异常后,会释放锁
 * 一旦抛出了异常，第二个线程会立刻进入同步方法，意味着锁已经释放
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/8
 */
@Slf4j
public class Demo7 implements Runnable {
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized void method1(){
        log.info("开始调用方法1");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("结束调用方法1");
    }

    public synchronized void method2(){
        log.info("开始调用方法2");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("结束调用方法2");
    }

    public static void main(String[] args) {
        Runnable runnable = new Demo7();
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t1.interrupt();
        t2.start();
        log.info("finish!");
    }
}
