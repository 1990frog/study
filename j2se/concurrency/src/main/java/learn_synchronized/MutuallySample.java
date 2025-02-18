package learn_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 为互斥锁
 * Thread 持有锁才能调用
 */
public class MutuallySample {

    public static synchronized void method1(){
        try {
            System.out.println(Thread.currentThread().getName() + " invoked method1");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " released method1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void method2(){
        try {
            System.out.println(Thread.currentThread().getName() + " invoked method2");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " released method2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * t1 占用了 MutexSample.class 类锁，导致 t2 无法获取阻塞
     *
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(MutuallySample::method1, "t1");
        Thread t2 = new Thread(MutuallySample::method1, "t2");
        t1.start();
        t2.start();
    }
}
