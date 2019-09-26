package src.main.java.concurrency.moocwukong.threadcoreknowledge.stopthreads;

/**
 * 描述：
 * 注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 * 可将Thread看成this类似
 */
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志,threadOne被中断：ture
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        //获取中断标志并重置，main的中断状态被重置：false
        System.out.println("isInterrupted: " + threadOne.interrupted());
        //获取中断标志并重置，main的中断状态被重置：false
        System.out.println("isInterrupted: " + Thread.interrupted());
        //获取中断标志,threadOne的中断状态：ture
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
