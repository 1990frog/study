package learn_thread;

import java.util.concurrent.TimeUnit;

public class StateSample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                synchronized (StateSample.class) {
                    StateSample.class.wait();
                }
                synchronized (StateSample.class) {
                    System.out.println("获取到 StateSample.class 锁");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.getState());
        TimeUnit.SECONDS.sleep(3);
        System.out.println(thread.getState());
        synchronized (StateSample.class) {
            StateSample.class.notify();
            TimeUnit.SECONDS.sleep(1);
            System.out.println(thread.getState());
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.getState());
    }
}
