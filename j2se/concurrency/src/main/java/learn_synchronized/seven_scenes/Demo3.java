package learn_synchronized.seven_scenes;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 两个线程访问的是synchronized的静态方法
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/8
 */
@Slf4j
public class Demo3 implements Runnable {

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        log.info("{} 运行开始！", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("{} 运行结束！", Thread.currentThread().getName());
    }

    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread(new Demo3());
        Thread t2 = new Thread(new Demo3());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
