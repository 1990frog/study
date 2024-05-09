package learn_synchronized.seven_scenes;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 同时访问同步方法与非同步方法
 * 一个方法加synchronized修饰不影响另一个方法的并发，非同步方法不受同步方法的影响
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/8
 */
@Slf4j
public class Demo4 implements Runnable {

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            method1();
        } else {
            method2();
        }
    }

    @SneakyThrows
    public synchronized void method1() {
        log.info("lock thread :{} is start!", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
        log.info("lock thread :{} is finish!", Thread.currentThread().getName());
    }

    @SneakyThrows
    public void method2() {
        log.info("unlock thread :{} is start!", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
        log.info("unlock thread :{} is finish!", Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable runnable = new Demo4();
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t2.start();
    }
}
