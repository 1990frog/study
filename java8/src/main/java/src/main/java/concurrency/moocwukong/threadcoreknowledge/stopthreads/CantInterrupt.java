package src.main.java.concurrency.moocwukong.threadcoreknowledge.stopthreads;

/**
 *
 * 描述：
 * 如果while里面放try/catch，会导致中断失效
 *
 * java设计sleep函数理念：如果sleep一旦响应中断，便会把interupted这个标记位清除
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
