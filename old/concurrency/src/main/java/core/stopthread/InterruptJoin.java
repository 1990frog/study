package core.stopthread;

import org.testng.annotations.Test;

public class InterruptJoin {

    /**
     * 逻辑：
     * 1.子线程中断主线程
     * 2.主线程被中断后，中断子线程
     */
    @Test
    public void test1(){

        // 获取主线程
        Thread mainThread = Thread.currentThread();

        // 创建子线程
        Thread thread1 = new Thread(() -> {
            try {
                // 中断主线程
                mainThread.interrupt();
                Thread.sleep(5000);
                System.out.println("子线程运行结束");
            } catch (InterruptedException e) {
                System.out.println("子线程中断");
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");

        try {
            // 先运行子线程
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"主线程中断了");
            // 主线程中断的同时，将中断传递给子线程，主线程与子线程中断
            thread1.interrupt();
        }

        System.out.println("主线程已运行完毕");
    }

    /**
     * 逻辑：
     * 1.主线程创建子线程1，2
     * 2.子线程1等待主线程先运行（join）
     * 2.子线程2被启动终结子线程1和主线程
     * @throws InterruptedException
     */
    @Test
    public void test2() {
        // 获取主线程
        Thread mainThread = Thread.currentThread();

        // 创建子线程1
        Thread thread1 = new Thread(()->{
            try {
                /**
                 * thread1.join的过程：waiting状态
                 * 先运行主线程main
                 */
                mainThread.join();
                System.out.println("子线程1等待主线程运行结束！");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("子线程1被中断");
            }
            System.out.println("子线程1运行完毕！");
        });

        // 创建子线程2
        Thread thread2 = new Thread(()->{
            // 子线程2去中断子线程1
            thread1.interrupt();
            mainThread.interrupt();
            System.out.println("子线程2运行结束！");
        });

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            System.out.println("我是主线程，我被干掉了！");
        }
        System.out.println("主线程运行结束！");
    }
}
