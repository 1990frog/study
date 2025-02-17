package learn_synchronized;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SynchronizedSample {

    @Test
    public void waitAndNotifyAndNotifyAll() throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (SynchronizedSample.class) {
                try {
                    System.out.println("t1 wait");
                    SynchronizedSample.class.wait();
                    System.out.println("t1 run");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1");
        Thread t2 = new Thread(()->{
            synchronized (SynchronizedSample.class) {
                System.out.println("t2 run notify");
                SynchronizedSample.class.notify();
                SynchronizedSample.class.notifyAll();
            }
        },"t2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("end");
    }

    /**
     * wait() 释放锁，释放CPU资源
     * sleep() 不释放锁
     * @throws InterruptedException
     */
    @Test
    public void waitAndSleep() throws InterruptedException {

        // wait() 会释放锁
        Thread waitThread = new Thread(()->{
            synchronized (SynchronizedSample.class) {
                try {
                    SynchronizedSample.class.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "waitThread");

        // sleep() 不会释放锁
        Thread sleepThread = new Thread(()->{
            synchronized (SynchronizedSample.class) {
                try {
                    System.out.println("sleepThread get monitor");
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "sleepThread");

        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        sleepThread.start();
    }

    public synchronized void synchronizedMethod(int loop){
        if(loop == 0)
            return;
        System.out.println(loop);
        synchronizedMethod(--loop);
    }

    /**
     * synchronized 是自旋锁
     */
    @Test
    public void synchronizedMethodTest(){
        synchronizedMethod(10);
    }

    /**
     * 溢出测试
     */
    public static List<InitParams> instances = new ArrayList<>();

    class InitParams{
        public int a;
        public int b;
        public InitParams() {
            this.a = 10;
            instances.add(this);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.b = 20;
        }
    }

    @Test
    public void initParamsTest() throws InterruptedException {
        new Thread(InitParams::new).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(instances.get(0).b);
        TimeUnit.SECONDS.sleep(15);
        System.out.println(instances.get(0).b);
    }


    class BaseClass{
        public synchronized void method(){
            try {
                System.out.println(Thread.currentThread().getName() + "开始执行！");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "结束执行！");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class ExtensionClass extends BaseClass{
//        public void method(){
//            super.method();
//        }
    }

    /**
     * `synchronized` 关键字不能被多态继承。
     * 如果父类中的某个方法是 `synchronized` 的，
     * 而子类中覆盖了这个方法，那么默认情况下子类中的这个方法并不是 `synchronized` 的，
     * 必须显式的在子类的这个方法中加上 `synchronized` 关键字才行。当然，不覆盖的话没事。
     * <p>
     * 不过子类的那个方法也可以通过调用父类中该相应的方法来实现 `synchronized` 效果。
     */
    @Test
    public void polymorphismTest() throws InterruptedException {
        ExtensionClass extensionClass = new ExtensionClass();
        Thread t1 = new Thread(extensionClass::method);
        Thread t2 = new Thread(extensionClass::method);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("end");
    }
}
