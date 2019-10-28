package src.main.java.base.concurrency.mydemo;

import java.util.concurrent.TimeUnit;

/**
 * 1.先写个可响应中断的方法
 * 什么是可响应中断的方法呢？
 * 那就是有判断当先线程状态的
 *
 */
public class InterruptMethod {

    public void method1() throws InterruptedException{
        /**
         * throws InterruptedException
         * 发生阻塞？
         * 长时间运行的方法不等于阻塞
         * 但这两种都推荐有终止运行的机制
         */
//        for (;;){
//            if(Thread.currentThread().isInterrupted()){
//                break;
//            }
//        }
        while (Thread.currentThread().isInterrupted());
        throw new InterruptedException();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            InterruptMethod interruptMethod = new InterruptMethod();
            try {
                interruptMethod.method1();
            } catch (InterruptedException e) {
                System.out.println("this thread is stop!");
            }
        });
        thread.start();
        Thread.sleep(10);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("我要触发interrupt了哈！");
        thread.interrupt();
        System.out.println("我触发结束了！");
        thread.join();
        System.out.println("thread 线程结束了！");
    }

}
