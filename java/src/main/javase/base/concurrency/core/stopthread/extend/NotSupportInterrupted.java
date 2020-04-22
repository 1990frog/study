package javase.base.concurrency.core.stopthread.extend;

import static java.lang.Thread.sleep;

/**
 * interrupt只能中断相应中断的线程
 */
public class NotSupportInterrupted implements Runnable{

    @Override
    public void run() {
        method1();
        method2();
    }

    /**
     * 不能响应中断
     */
    public static void method1(){
        for(;;) {
        }
    }

    /**
     * 响应中断
     */
    public static void method2(){
        for(;;) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().isInterrupted());
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NotSupportInterrupted());
        thread.start();
        sleep(1000);
        System.out.println("开始执行中断！");
        thread.interrupt();
        System.out.println("中断申请完成！");
        System.out.println("Thread state:"+thread.getState());
    }

}
