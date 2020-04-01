package javase.base.concurrency.mydemo.core.stopthread.rightinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * 传递中断
 */
public class TransmitInterrupt implements Runnable{

    @Override
    public void run() {
        System.out.println("running!");
        try {
            sleep();
        } catch (InterruptedException e) {
            System.out.println("啊！我被中断了！");
            e.printStackTrace();
        }
    }

    // 此处向上抛出中断状态
    public void sleep() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TransmitInterrupt());
        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt();
        thread.join();
        System.out.println("跑完收工");

    }
}
