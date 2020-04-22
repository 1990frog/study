package javase.base.concurrency.core.stopthread.extend;

import static java.lang.Thread.sleep;

public class InterruptedMethod implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptedMethod());
        thread.start();
//        sleep(1000);
//        thread.interrupt();

    }

    @Override
    public void run() {
        //再次中断
//        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        //恢复中断标记位
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
//        Thread.interrupted();
//        System.out.println(Thread.currentThread().isInterrupted());
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("未中断！");
            break;
        }

//        try {
//            sleep(3000);
//        }catch (InterruptedException e){
//            System.out.println("invoke Thread.interrupted():"+Thread.interrupted());
//            System.out.println("invoke Thread.currentThread().isInterrupted():"+Thread.currentThread().isInterrupted());
//            e.printStackTrace();
//        }
    }
}
