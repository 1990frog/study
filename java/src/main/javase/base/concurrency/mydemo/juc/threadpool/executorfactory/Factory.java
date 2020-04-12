package javase.base.concurrency.mydemo.juc.threadpool.executorfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Factory {

    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);


    }
}
