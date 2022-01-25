package juc.flowcontrol.countdownlanch;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo0 implements Runnable {

    private static CountDownLatch countDownLatch = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatchDemo0 runner = new CountDownLatchDemo0();
        for (int i = 0; i < 5; i++) {
            executorService.submit(runner);
            countDownLatch.countDown();
        }
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(3);
        countDownLatch.countDown();
        while (executorService.isTerminated()) {
            System.out.println("end!");
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        countDownLatch.await();
        System.out.println("run");
    }

}
