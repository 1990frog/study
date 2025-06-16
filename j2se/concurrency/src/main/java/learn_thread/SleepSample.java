package learn_thread;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SleepSample {

    @Test
    public void sleep() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Thread.currentThread().getName() + "休息1s");
    }

    /**
     * TimeUtil 是一个枚举类
     */
    @Test
    public void timeUtil() {
        long start = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Thread.currentThread().getName() + "休息1s");
    }
}
