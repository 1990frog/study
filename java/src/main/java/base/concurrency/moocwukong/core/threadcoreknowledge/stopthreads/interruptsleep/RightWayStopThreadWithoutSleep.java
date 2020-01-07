package base.concurrency.moocwukong.core.threadcoreknowledge.stopthreads.interruptsleep;

/**
 * 描述：
 * run方法内没有sleep或wait方法时，停止线程
 *
 * 疑问：
 * 为何run方法中的循环没办法被中断？
 *
 * 因为调用Thread.interrupt()方法，只是将线程的状态改变为中断，并不会直接中断线程
 * 所以可以在循环中判断中断状态是否改变
 *
 * %interrupt的中断处理，需要自己手动处理%
 */
public class RightWayStopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }

//        /**
//         * for 也可以实现
//         */
//        for(int i=0;i<Integer.MAX_VALUE/2 && !Thread.currentThread().isInterrupted();i++){
//            if (i % 10000 == 0) {
//                System.out.println(i + "是10000的倍数");
//            }
//        }

        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();//中断线程，更改被中断线程状态（isInterrupted:true）
    }

    /**
     *
     * public void interrupt（）
     *
     * Interrupts this thread.
     * 中断此线程。
     *
     * Unless the current thread is interrupting itself, which is always permitted, t
     * he checkAccess method of this thread is invoked, which may cause a SecurityException to be thrown.
     * 除非当前线程正在中断自身（始终允许），否则将调用此线程的checkAccess方法，这可能导致抛出SecurityException。
     *
     * If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the Object class,
     * or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int), methods of this class,
     * then its interrupt status will be cleared and it will receive an InterruptedException.
     * 如果在调用Object类的wait（），wait（long）或wait（long，int）方法，或者join（），join（long），join（long，int）方法中阻塞了这个线程，
     * sleep（long）或sleep（long，int），这个类的方法，然后它的中断状态将被清除，它将收到InterruptedException。
     *
     * If this thread is blocked in an I/O operation upon an InterruptibleChannel then the channel will be closed,
     * the thread's interrupt status will be bobo.playdatastructure.set, and the thread will receive a ClosedByInterruptException.
     * 如果在InterruptibleChannel上的I / O操作中阻塞了该线程，则该通道将被关闭，线程的中断状态将被设置，并且线程将收到ClosedByInterruptException。
     *
     * If this thread is blocked in a Selector then the thread's interrupt status will be bobo.playdatastructure.set and it will return immediately from the selection operation,
     * possibly with a non-zero value, just as if the selector's wakeup method were invoked.
     * 如果此线程在Selector中被阻塞，则线程的中断状态将被设置，并且它将立即从选择操作返回，可能具有非零值，就像调用选择器的唤醒方法一样。
     *
     * If none of the previous conditions hold then this thread's interrupt status will be bobo.playdatastructure.set.
     * 如果以前的条件都不成立，则将设置该线程的中断状态。
     *
     * Interrupting a thread that is not alive need not have any effect.
     * 中断不活动的线程不会产生任何影响。
     *
     * Throws:
     * SecurityException - if the current thread cannot modify this thread
     * 抛出：
     * SecurityException  - 如果当前线程无法修改此线程
     */
}
