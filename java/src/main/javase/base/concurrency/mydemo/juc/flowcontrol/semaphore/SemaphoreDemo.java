package javase.base.concurrency.mydemo.juc.flowcontrol.semaphore;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreDemo implements Runnable {

    static Semaphore semaphore = new Semaphore(1,true);
//    static AtomicInteger counter = new AtomicInteger(0);
    int counter = 0;

    @SneakyThrows
    @Override
    public void run() {
        for(;;){
            semaphore.acquire();
            TimeUnit.SECONDS.sleep(1);
            System.out.println(counter++);
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        SemaphoreDemo runner = new SemaphoreDemo();
        for (int i = 0; i < 10; i++) {
            executorService.submit(runner);
        }
    }
}