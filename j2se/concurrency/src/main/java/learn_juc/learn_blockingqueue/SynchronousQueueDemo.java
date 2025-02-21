package learn_juc.learn_blockingqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    static SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

    public static void main(String[] args) {
        Thread producer = new Thread(()->{
            try {
                System.out.println("producer begin");
                synchronousQueue.put(10);
                System.out.println("producer close");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(()->{
            try {
                System.out.println("consumer begin");
                Integer val = synchronousQueue.take();
                System.out.println("consumer close, get "+val);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        consumer.start();
    }
}
