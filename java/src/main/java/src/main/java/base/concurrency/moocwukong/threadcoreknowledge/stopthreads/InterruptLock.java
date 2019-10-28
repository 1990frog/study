package src.main.java.base.concurrency.moocwukong.threadcoreknowledge.stopthreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptLock implements Runnable{

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
//        lock.lock();
//        try {
//            while (true);
////            Thread.sleep(100);
//        }catch (InterruptedException e){
//            System.out.println("The Task is interrupted!");
//        }finally {
//            lock.unlock();
//        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptLock());
        thread.start();
        thread.interrupt();
    }
}

