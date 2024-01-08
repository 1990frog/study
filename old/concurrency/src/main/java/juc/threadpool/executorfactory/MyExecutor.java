package juc.threadpool.executorfactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10,
                20,60, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
    }
}
