package base.concurrency.mylock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MyReentrantLockTest {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void try1(){
        synchronized (lock1){
            System.out.println("method try1");
            try2();
        }
    }

    public void try2(){
        synchronized (lock1){
            System.out.println("method try2");
        }
    }

    public void try3(){
        synchronized (lock1){
            System.out.println("has lock1");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                try4();
                System.out.println("has lock2");
            }
        }
    }

    public void try4(){
        synchronized (lock2){
            System.out.println("has lock2");
            synchronized (lock1){
                System.out.println("has lock1");
            }
        }
    }

    /**
     * 测试可重入性:单把锁
     */
    @Test
    public void test1(){
        new MyReentrantLockTest().try1();
    }

    /**
     * 测试可重入性:两把锁
     */
    @Test
    public void test2(){
        new MyReentrantLockTest().try3();
    }

    /**
     * 测试死锁：各持有一把锁
     */
    @Test
    public void test3() throws InterruptedException {
        MyReentrantLockTest reentrantLockTest = new MyReentrantLockTest();
        Thread thread1 = new Thread(()->reentrantLockTest.try3());
        Thread thread2 = new Thread(()->reentrantLockTest.try4());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("the test is end.");
    }

}
