package javase.base.concurrency.core.threadmethod;

/**
 * 描述：
 * 演示打印main, Thread-0, Thread-1
 */
public class CurrentThread implements Runnable {

    public static void main(String[] args) {
        //主线程方法调用
        new CurrentThread().run();
        //线1线2
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
