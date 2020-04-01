package javase.base.concurrency.mydemo.core.stopthread.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 描述：
 * 演示用volatile的局限part2 陷入阻塞时，volatile是无法中断线程的
 * 此例中，生产者的生产速度很快，消费者消费速度慢，
 * 所以阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费
 */
public class WrongWayVolatileCantStop {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 仓库，阻塞队列
         */
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);

        /**
         * 生产者
         */
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        /**
         * 消费者
         */
        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take()+"被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了。");

        /**
         * 一旦消费不需要更多数据了，我们应该让生产者也停下来，但是实际情况
         */
        producer.canceled=true;
        System.out.println(producer.canceled);
    }
}

/**
 * 生产者
 * 如果storage没满就会一直生产，storage满了就会发生阻塞，停止生产
 */
class Producer implements Runnable {

    public volatile boolean canceled = false;//volatile 中断线程，无法立刻抛出异常中断阻塞，要通过状态判断。

    //阻塞队列
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    /**
                     * 在循环体里面是没有检查逻辑的
                     * 阻塞发生在此处,标记位却在外面
                     * 此处没有被唤醒，就走不到while判断中，就会一直卡在这里
                     */
                    storage.put(num);
                    System.out.println(num + "是100的倍数,被放到仓库中了。");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者结束运行");
        }
    }
}

/**
 * 消费者
 */
class Consumer {

    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.95) {
            return false;
        }
        return true;
    }
}