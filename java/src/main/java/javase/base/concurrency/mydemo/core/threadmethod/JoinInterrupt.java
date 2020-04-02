package javase.base.concurrency.mydemo.core.threadmethod;

/**
 * 描述：
 * 演示join期间被中断的效果
 */
public class JoinInterrupt {

    public static void main(String[] args) {

        //获取主线程
        Thread mainThread = Thread.currentThread();

        Thread thread1 = new Thread(() -> {
            try {
                //中断主线程
                mainThread.interrupt();
                Thread.sleep(5000);
                System.out.println("Thread1 finished.");
            } catch (InterruptedException e) {
                System.out.println("子线程中断");
            }
        });

        thread1.start();
        System.out.println("等待子线程运行完毕");

        try {
            //主线程中断的同时，将中断传递给子线程，主线程与子线程中断
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"主线程中断了");
            thread1.interrupt();
        }

        System.out.println("子线程已运行完毕");
    }

}
