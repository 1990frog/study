package learn_synchronized;

import org.testng.annotations.Test;

public class WaitSample {

    public synchronized void waitMethod(){
        try {
            System.out.println(Thread.currentThread().getName() + ": 调用 wait");
            wait();
            System.out.println(Thread.currentThread().getName() + ": 结束 wait");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    public synchronized void notifyMethod(){
    public void notifyMethod(){
        notify();
        System.out.println(Thread.currentThread().getName() + ": 调用 notify");
    }

    public void notifyAllMethod(){
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ": 调用 notifyAll");
    }

    /**
     * 当调用 wait/notify/notifyAll 方法，当前线程必须获取到锁才行
     * @throws InterruptedException
     */
    @Test
    public void testNotifyMethod() throws InterruptedException {
        WaitSample waitSample = new WaitSample();
        Thread t1 = new Thread(waitSample::waitMethod);
        Thread t2 = new Thread(waitSample::waitMethod);
        Thread t3 = new Thread(waitSample::notifyMethod);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("结束");
    }
}
