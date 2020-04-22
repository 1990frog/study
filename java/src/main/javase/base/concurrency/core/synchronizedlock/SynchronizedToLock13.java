package javase.base.concurrency.core.synchronizedlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedToLock13 {

    Lock lock = new ReentrantLock();

    public synchronized void method1(){//内置锁
        System.out.println("我是Synchronized形式的锁");
    }

    public void method2(){//显式锁
        lock.lock();
        try {
            System.out.println("我是lock形式的锁");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock13 synchronizedToLock13 = new SynchronizedToLock13();
        synchronizedToLock13.method1();
        synchronizedToLock13.method2();
    }
}
