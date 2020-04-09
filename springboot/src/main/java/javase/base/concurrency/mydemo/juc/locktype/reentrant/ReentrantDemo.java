package javase.base.concurrency.mydemo.juc.locktype.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    public void method() {
        lock.lock();
        System.out.println("do atomic operation");
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        method();
    }

    public static void main(String[] args) {
        ReentrantDemo context = new ReentrantDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i ++ ) {
            executorService.submit(new ReentrantDemo());
        }
    }
}
