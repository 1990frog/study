package learn_juc.learn_countdownlatch;

import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchSampleDemo {

    @Test
    public void test1(){
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(9);
        for (int i = 0; i < 9; i++) {
            service.submit(countDownLatch::countDown);
        }
        service.shutdown();

        // 守护线程发现主线程阻塞 -1
        Thread main = Thread.currentThread();
        Thread daemon = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (main.getState() == Thread.State.WAITING) {
                countDownLatch.countDown();
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("前置条件结束！");
    }

    @Test
    public void test2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(()->{
                try {
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        TimeUnit.SECONDS.sleep(3);
        countDownLatch.countDown();
        service.shutdown();
    }

}
