package lock;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/7
 */
public class SynchronizedDemo {

    private static Object lock = new Object();

    @Test
    public void objectLockTest(){

        Runnable runnable = ()->{
            synchronized (lock){
                try {
                    Thread.sleep(1000L);
                    System.out.println("hello " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }

    public synchronized void synchronizedMethod(){
        try {
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void synchronizedMethodTest(){
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = synchronizedDemo::synchronizedMethod;
        for (int i = 0; i < 10; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }

    public synchronized static void synchronizedStaticMethod(){
        try {
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
//        synchronizedDemo.objectLockTest();

        synchronizedDemo.synchronizedMethodTest();
    }

}
