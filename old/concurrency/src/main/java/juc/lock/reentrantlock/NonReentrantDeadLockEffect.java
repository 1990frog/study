package juc.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class NonReentrantDeadLockEffect implements Runnable {

    /**
     * 公平锁，没有可重入性
     */
    static ReentrantLock lock = new ReentrantLock(false);

    public void foo(){
        try{
            lock.lock();
            System.out.println("foo");
            bar();
        }finally {
            lock.unlock();
        }
    }

    public void bar(){
        try{
            lock.lock();
            System.out.println(lock.getHoldCount());
            System.out.println("bar");
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        foo();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NonReentrantDeadLockEffect());
        Thread thread2 = new Thread(new NonReentrantDeadLockEffect());
        thread1.start();
//        thread2.start();
    }
}
