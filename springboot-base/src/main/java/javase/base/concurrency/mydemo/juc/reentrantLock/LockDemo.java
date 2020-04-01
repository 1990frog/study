package javase.base.concurrency.mydemo.juc.reentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private static ReentrantLock lock = new ReentrantLock(true);
    private int index = 0;

    public void count(){
        while (true){
            try {
                lock.lock();
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("Thread"+Thread.currentThread().getId()+"："+index++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 构造器传null，非公平锁，可重入锁，输出应该是有序的
     *
     * 如果我的锁是可重入锁，一个线程获取锁后死循环，会阻塞调其他线程吗？
     *
     * 可重入锁被插队？
     *
     */
    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=0;i<3;i++)
            executor.submit(()->lockDemo.count());//ReentrantLock是可重入锁，所以它的输出是有序的
        executor.shutdown();
    }
}
