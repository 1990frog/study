package src.main.java.concurrency.moocwukong.threadcoreknowledge.stopthreads.other;

import static java.lang.Thread.sleep;

public class InterruptedTest implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptedTest());
        thread.start();
        sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        System.out.println("invoke Thread.interrupted():"+Thread.interrupted());
        try {
            sleep(3000);
        }catch (InterruptedException e){
            System.out.println("invoke Thread.interrupted():"+Thread.interrupted());
            System.out.println("invoke Thread.currentThread().isInterrupted():"+Thread.currentThread().isInterrupted());
            e.printStackTrace();
        }
    }
}
