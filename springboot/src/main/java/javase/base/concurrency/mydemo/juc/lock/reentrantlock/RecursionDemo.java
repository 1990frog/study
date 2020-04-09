package javase.base.concurrency.mydemo.juc.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：
 * 对需要递归的场景，而又不愿意放弃锁的，可以直接+1获取锁
 */
public class RecursionDemo {

    private static ReentrantLock lock = new ReentrantLock();

    private static void accessResource() {
        lock.lock();
        try {
            System.out.println("已经对资源进行了处理");
            if (lock.getHoldCount()<5) {
                System.out.println(lock.getHoldCount());
                /**
                 * 可重入锁会先判断state==0，是否有人持锁，如果不等于0，接着判断持锁对象是否是自己，如果是+1
                 */
                accessResource();
                System.out.println(lock.getHoldCount());
            }
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        accessResource();
    }
}
