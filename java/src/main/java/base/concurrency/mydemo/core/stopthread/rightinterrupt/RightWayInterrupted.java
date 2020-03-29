package base.concurrency.mydemo.core.stopthread.rightinterrupt;

/**
 * 描述：
 * 注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 * 可将Thread看成this类似
 */
public class RightWayInterrupted {

    /**
     * output:
     * isInterrupted: true
     * isInterrupted: false
     * isInterrupted: false
     * isInterrupted: true
     *
     * Thread.interrupted()方法调用，只作用于当前线程：
     * public static boolean interrupted() {
     *      return currentThread().isInterrupted(true);
     * }
     */
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
//                    if(Thread.currentThread().isInterrupted()){
//                        break;
//                        Thread.interrupted();
//                    }
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();//threadOne is true
        //获取中断标志,threadOne被中断：ture
        System.out.println("isInterrupted: " + threadOne.isInterrupted());//threadOne is true
        //获取中断标志并重置，main的中断状态被重置：false
        System.out.println("isInterrupted: " + threadOne.interrupted());//main is false
        //获取中断标志并重置，main的中断状态被重置：false
        System.out.println("isInterrupted: " + Thread.interrupted());//main is false
        //获取中断标志,threadOne的中断状态：ture
        System.out.println("isInterrupted: " + threadOne.isInterrupted());//threadOne is true
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
