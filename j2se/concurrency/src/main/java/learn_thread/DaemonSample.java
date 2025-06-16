package learn_thread;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程类型取决于创建其的线程类型
 * 当所有线程都结束时，守护线程会自动终止
 */
public class DaemonSample {

    @Test
    public void test1() {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("thread start，优先级：" + Thread.currentThread().getPriority());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("thread end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread daemon = new Thread(() -> {
            try {
                thread.join();
                System.out.println("守护线程join测试，优先级：" + Thread.currentThread().getPriority());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        // setDaemon()方法必须在start()方法前设置，否则报错
        daemon.setDaemon(true);

        daemon.start();
        thread.start();

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("用户线程，优先级：" + Thread.currentThread().getPriority());
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("守护线程，优先级：" + Thread.currentThread().getPriority());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(i);
                }
            });
            t2.setDaemon(true);
            t2.start();
        });
        // 守护线程优先级会继承创建它的用户线程
//        t1.setPriority(1);
        t1.start();
        TimeUnit.SECONDS.sleep(30);
    }
}
