package base.concurrency.mydemo.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * incrementAndGet()的计算依赖于当前的值
 * incrementAndGet()保证了原子性、可见性
 * 保障了set()是原子的
 *
 * 但是：
 * incrementAndGet()与get()并没有保证原子性
 *
 */
public class AtomicSleepDemo {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    private static AtomicSleepDemo instance = new AtomicSleepDemo();

    public void add(){
        atomicInteger.incrementAndGet();
    }

    public Integer get(){
        return atomicInteger.get();
    }

    public synchronized void lockAdd(){//同步方法，只能保障方法内代码的原子性
        atomicInteger.incrementAndGet();
    }

    public synchronized Integer lockGet(){
        return atomicInteger.get();
    }

    public static void demo1(){
        System.out.println("初始值："+instance.get());
        new Thread(()->{
            instance.add();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1:"+instance.get());
        }).start();

        new Thread(()->{
            instance.add();
            instance.add();
            instance.add();
            System.out.println("Thread2:"+instance.get());
        }).start();
    }

    public static void demo2(){
        System.out.println("初始值："+instance.lockGet());
        new Thread(()->{
            instance.lockAdd();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1:"+instance.lockGet());
        }).start();

        new Thread(()->{
            instance.lockAdd();
            instance.lockAdd();
            instance.lockAdd();
            System.out.println("Thread2:"+instance.lockGet());
        }).start();
    }

    public static void main(String[] args) {
//        demo1();
        demo2();

    }

}
