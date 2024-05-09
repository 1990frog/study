package learn_synchronized.seven_scenes;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 两个线程访问两个对象的同步方法
 * 此时两个线程争抢的是不同的锁，synchronized不起作用
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/8
 */
@Slf4j
public class Demo2 implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            try {
                log.info("{} 运行开始！", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
                log.info("{} 运行结束！", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        log.info("{} 运行开始！", Thread.currentThread().getName());
        Thread t1 = new Thread(new Demo2());
        Thread t2 = new Thread(new Demo2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("{} 运行结束！", Thread.currentThread().getName());
    }
}
