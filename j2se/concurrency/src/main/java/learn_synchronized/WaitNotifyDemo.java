package learn_synchronized;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 线程结束之后是否会自动调用 notify？
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/9
 */
@Slf4j
public class WaitNotifyDemo implements Runnable {

    @Override
    public void run() {
        if ("wait".equals(Thread.currentThread().getName())) {
            wait_method();
        } else if ("notify".equals(Thread.currentThread().getName())) {
            notify_method();
        }
    }

    public synchronized void wait_method() {
        log.info("{} 调用 wait() 方法释放锁！", Thread.currentThread().getName());
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("{} 线程又获取到了锁，从新开始运行！", Thread.currentThread().getName());
    }

    public synchronized void notify_method() {
        log.info("{} 调用 notify() 方法尝试唤醒其他线程！", Thread.currentThread().getName());
        notify();
    }

    public static void main(String[] args) {
        Runnable r = new WaitNotifyDemo();
        Thread t1 = new Thread(r, "wait");
        Thread t2 = new Thread(r, "notify");
        t1.start();
        t2.start();
    }
}
