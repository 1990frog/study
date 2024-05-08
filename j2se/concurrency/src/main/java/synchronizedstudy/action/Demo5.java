package synchronizedstudy.action;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 访问同一个对象的不同普通同步方法
 * 此时指认this对象作为锁,对于同一个实例来说，锁是相同的
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/8
 */
@Slf4j
public class Demo5 implements Runnable {
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            method1();
        } else {
            method2();
        }
    }

    @SneakyThrows
    public synchronized void method1(){
        log.info("method1 thread :{} is start",Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
        log.info("method1 thread :{} is finish",Thread.currentThread().getName());
    }

    @SneakyThrows
    public synchronized void method2(){
        log.info("method2 thread :{} is start",Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
        log.info("method2 thread :{} is finish",Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable runnable = new Demo5();
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t2.start();
    }
}


