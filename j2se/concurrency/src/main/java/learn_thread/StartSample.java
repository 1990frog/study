package learn_thread;

import org.testng.annotations.Test;

/**
 *
 */
public class StartSample implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " StartSample start");
    }

    @Test
    public void startTest(){
        Thread thread = new Thread(this);
        thread.start();
    }

    @Test
    public void invokeRunTest(){
        Thread thread = new Thread(this);
        thread.run();
        thread.run();
    }

    /**
     * start 方法调用两次 报错 抛出 IllegalThreadStateException
     * 第一次调用 start 方法，Thread.threadStatus 状况改变
     * synchronized (this) {
     *             // zero status corresponds to state "NEW".
     *             if (holder.threadStatus != 0)
     *                 throw new IllegalThreadStateException();
     *             start0();
     *         }
     */
    @Test
    public void doubleStartTest(){
        Thread thread = new Thread(this);
        // holder.threadStatus = 0
        thread.start();
        // holder.threadStatus = 2
        thread.start();
    }



}
