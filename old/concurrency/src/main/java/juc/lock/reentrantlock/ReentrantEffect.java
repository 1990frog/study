package juc.lock.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantEffect {

    // 公平锁
    private static ReentrantLock lock;
    private int index = 0;

    /**
     * 循环执行（获取锁->+1->释放锁）的流程
     *
     * 目的：
     * ReentrantLock(true)公平锁，那么下次获取会自动进入队列
     * ReentrantLock()非公平锁，那么下次获取会CAS直接抢（因为其他的线程都在队列里，所以它们都抢不到了）
     */
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

    public static void nonfair(){
        lock = new ReentrantLock(false);
        ReentrantEffect reentrantEffect = new ReentrantEffect();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++)
            executor.submit(()-> reentrantEffect.count());//ReentrantLock是可重入锁，所以它的输出是有序的
        executor.shutdown();
    }

    public static void fair(){
        lock = new ReentrantLock(true);
        ReentrantEffect reentrantEffect = new ReentrantEffect();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++)
            executor.submit(()-> reentrantEffect.count());//ReentrantLock是可重入锁，所以它的输出是有序的
        executor.shutdown();
    }

    /**
     * 构造器传null，非公平锁，可重入锁，输出应该是有序的
     * 如果我的锁是可重入锁，一个线程获取锁后死循环，会阻塞调其他线程吗？
     * 可重入锁被插队？
     */
    public static void main(String[] args) {
        nonfair();
        fair();
    }


}
