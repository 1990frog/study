package javase.base.concurrency.core.stopthread.rightinterrupt;

import java.util.concurrent.TimeUnit;

interface foo{
    /**
     * 因为此方法签名未抛出受检查异常，所以无法抛出
     */
    void bar();
}

public class RecoverInterrupt implements foo,Runnable {

    /**
     * 只能吞掉异常不能抛出，但是可以重置线程状态
     */
    @Override
    public void bar() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) { // 触发InterruptException会重置中断状态为false
            Thread.currentThread().interrupt();// 重置
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("线程中断");
                break;
            }
            bar();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RecoverInterrupt());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }


}
