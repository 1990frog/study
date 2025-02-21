package learn_juc.learn_reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BasicSample {

    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock r = rwl.readLock();
    static ReentrantReadWriteLock.WriteLock w = rwl.writeLock();

    public static void readLock() {
        r.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Read Lock, readLockCount: " + rwl.getReadLockCount());
        } finally {
            r.unlock();
            System.out.println(Thread.currentThread().getName() + ": Read Unlock");
        }
    }

    public static void writeLock() {
        w.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Write Lock");
        } finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName() + ": Write Unlock");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(BasicSample::readLock).start();
        }
        for (int i = 0; i < 1000; i++) {
            new Thread(BasicSample::writeLock).start();
        }
    }

}
