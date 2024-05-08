package createthread;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * synchronized 修饰符
 * <p>
 * 1、同步代码块
 * 2、同步方法
 * 3、同步静态方法
 * 4、同步类
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/7
 */
public class SynchronizedDemo {

    private static final SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

    /**
     * 同步代码块
     */
    public void synchronizedBlock() {
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + "，开始运行！");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "，结束运行！");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 同步方法
     */
    public synchronized void synchronizedMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "，开始运行！");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + "，结束运行！");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void synchronizedMethod1() {
        System.out.println(Thread.currentThread().getName() + "，开始运行！");
        this.method1();
        System.out.println(Thread.currentThread().getName() + "，结束运行！");
    }

    public void method1(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void synchronizedMethodCallNormalMethod() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " thread is start");
        Runnable runnable = synchronizedDemo::synchronizedMethod1;
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + " thread is end");
    }

    /**
     * 同步静态方法
     */
    public synchronized static void synchronizedStaticMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "，开始运行！");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + "，结束运行！");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test(invocationCount = 5, threadPoolSize = 3)
    public void synchronizedCodeBlockTest() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " thread is start");
        Runnable runnable = synchronizedDemo::synchronizedBlock;
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + " thread is end");
    }

    @Test(invocationCount = 5, threadPoolSize = 3)
    public void synchronizedMethodTest() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " thread is start");
        Runnable runnable = synchronizedDemo::synchronizedMethod;
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + " thread is end");
    }

    @Test(invocationCount = 5, threadPoolSize = 3)
    public void synchronizedStaticMethodTest() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " thread is start");
        Runnable runnable = SynchronizedDemo::synchronizedStaticMethod;
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + " thread is end");
    }

    
}
