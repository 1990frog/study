package base.concurrency.mydemo.core.error;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：
 * 第一种：运行结果出错。
 * 演示计数不准确（减少），找出具体出错的位置。
 *
 * 找出错误的具体位置为目标
 *
 */
public class MultiThreadsError implements Runnable {

    static MultiThreadsError instance = new MultiThreadsError();
    int index = 0;
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();
    /**
     * CyclicBarrier可以让我们的线程,可以根据我们的需要在某一个地方等待
     * 传参代表等待的线程数,此处等待两个线程
     */
    static volatile CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static volatile CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    final boolean[] marked = new boolean[10000000];

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面上结果是" + instance.index);
        System.out.println("真正运行的次数" + realIndex.get());
        System.out.println("错误次数" + wrongCount.get());

    }

    @Override
    public void run() {
    	marked[0] = true;
        for (int i = 0; i < 10000; i++) {
            try {
                /**
                 * 重置
                 */
                cyclicBarrier2.reset();
                /**
                 * 如果两个线程都执行await就会放行
                 */
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            /**
             * 此demo统计的错误皆发生在++过程中
             */
            index++;

            try {
                cyclicBarrier1.reset();
                /**
                 * 保障两个线程并驾齐驱,index相加发生在一个阶段
                 */
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();

//            synchronized (instance) {
//                if (marked[index]) {
//                    System.out.println("发生错误" + index);
//                    wrongCount.incrementAndGet();
//                }
//                marked[index] = true;
//            }

            /**
             * synchronized保障可见性
             */
            synchronized (instance) {
                if (marked[index] && marked[index - 1]) {
                    System.out.println("发生错误" + index);
                    wrongCount.incrementAndGet();
                }
                marked[index] = true;
            }
        }
    }
}
