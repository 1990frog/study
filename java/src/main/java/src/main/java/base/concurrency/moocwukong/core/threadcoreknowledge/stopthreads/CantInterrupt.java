package src.main.java.base.concurrency.moocwukong.core.threadcoreknowledge.stopthreads;

/**
 *
 * 描述：
 * 如果while里面放try/catch，会导致中断失效
 * @See ExceptionInWhile.java
 *
 * java设计sleep函数理念：
 * 如果sleep一旦响应中断，便会把interupted这个标记位清除
 * 更准确的形容为：如果触发了InteruptedException之后，会清空中断状态标记位
 *
 * interrupted 是作用于当前线程（currentThread）,恢复标记位（中断状态恢复为未中断状态）
 * public static boolean interrupted() {
 *      return currentThread().isInterrupted(true);//ture 更新标记位
 * }
 *
 * isInterrupted 是作用于调用该方法的线程对象所对应的线程。
 * （线程对象对应的线程不一定是当前运行的线程。例如我们可以在A线程中去调用B线程对象的isInterrupted方法。）
 * public boolean isInterrupted() {
 *     return isInterrupted(false);//false 不更新标记位
 * }
 *
 * private native boolean isInterrupted(boolean ClearInterrupted);
 *
 * 原来这是一个本地方法，看不到源码。不过没关系，通过参数名ClearInterrupted我们就能知道，这个参数代表是否要清除状态位。
 * 如果这个参数为true，说明返回线程的状态位后，要清掉原来的状态位（恢复成原来情况）。
 * 这个参数为false，就是直接返回线程的状态位。
 * 这两个方法很好区分，只有当前线程才能清除自己的中断位（对应interrupted（）方法）
 *
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);//Thread.currentThread().isInterrupted()状态被清空了
                } catch (InterruptedException e) {

                    /**
                     * @stackoverflow
                     * InterruptedException - if any thread has interrupted the current thread.
                     * The interrupted status of the current thread is cleared when this exception is thrown.
                     *
                     * @api
                     * Tests whether the current thread has been interrupted.
                     * The <i>interrupted status</i> of the thread is cleared by this method.
                     * In other words, if this method were to be called twice in succession,
                     * the second call would return false (unless the current thread were nterrupted again,
                     * after the first call had cleared its interrupted status and before the second call had examined it).
                     *
                     * 测试当前线程是否已被中断。此方法清除线程的中断状态。换句话说，如果连续两次调用此方法，
                     * 则第二次调用将返回false（除非当前线程在第一次调用已清除其中断状态之后且在第二次调用检查之前再次中断）
                     * 线程中断被忽略，因为在中断时线程不活动将被此方法反应返回false
                     * 返回：
                     * true如果当前线程已被中断
                     * false除此以外
                     *
                     * <p>A thread interruption ignored because a thread was not alive
                     * at the time of the interrupt will be reflected by this method
                     * returning false.
                     *
                     * @return  <code>true</code> if the current thread has been interrupted;
                     *          <code>false</code> otherwise.
                     * @see #isInterrupted()
                     * @revised 6.0
                     */
                    Thread.interrupted();//无效
                    e.printStackTrace();

                    /**
                     * 传递中断状态
                     */
//                    Thread.currentThread().interrupt();//有效
//                    e.printStackTrace();
                }
            }

            /**
             * Actually your question is more about try - catch - finally than about multithreading.
             * 1) If sleep throws an Exception, the catch block will execute and then the while loop continues.
             * 2) You do the exact same thing as in 1)
             * To leave the while loop, do:
             */
//            try{
//                while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
//                    if (num % 100 == 0) {
//                        System.out.println(num + "是100的倍数");
//                    }
//                    num++;
//                    Thread.sleep(10);//Thread.currentThread().isInterrupted()状态被清空了
//                }
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
