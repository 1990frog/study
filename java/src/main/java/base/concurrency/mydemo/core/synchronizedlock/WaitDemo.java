package base.concurrency.mydemo.core.synchronizedlock;

import java.util.concurrent.TimeUnit;

/**
 * wait(),notify()都必须在synchronized中调用，切记
 */
public class WaitDemo implements Runnable {


    @Override
    public void run() {
        play1();
    }

    public synchronized void play1() {
        System.out.println(Thread.currentThread().getName());
        try {
            if("thread1".equals(Thread.currentThread().getName())){
                wait();
            }else {
                notify();
                System.out.println("notify ....");
            }
            TimeUnit.SECONDS.sleep(10);
//            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is stop");
    }


    public static void main(String[] args) throws InterruptedException {
        WaitDemo demo = new WaitDemo();
        Thread thread1 = new Thread(demo);
        thread1.setName("thread1");
        Thread thread2 = new Thread(demo);
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("all stop");
    }
}
