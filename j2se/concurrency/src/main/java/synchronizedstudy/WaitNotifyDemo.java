package synchronizedstudy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/9
 */
@Slf4j
public class WaitNotifyDemo implements Runnable {

    @Override
    public void run() {
        if("t1".equals(Thread.currentThread().getName())){
            method1();
        } else if ("t2".equals(Thread.currentThread().getName())) {
            method2();
        } else{
            method3();
        }
    }

    public synchronized void method1(){
        log.info("{} :method1 is start", Thread.currentThread().getName());
        try {
            wait();
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("{} :method1 is finish", Thread.currentThread().getName());
    }

    public synchronized void method2(){
        log.info("{} :method2 is start", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
        log.info("{} :method2 is finish", Thread.currentThread().getName());
    }

    public synchronized void method3(){
        log.info("{} :method3 is start", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("{} :method3 is finish", Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable r = new WaitNotifyDemo();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        Thread t3 = new Thread(r, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
