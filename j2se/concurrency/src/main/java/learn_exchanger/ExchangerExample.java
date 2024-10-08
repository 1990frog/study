package learn_exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * 一个线程在完成一定的事务后想与另一个线程交换数据，则第一个先拿出数据的线程会一直等待第二个线程，直到第二个线程拿着数据到来时才能彼此交换对应数据。
 */
public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        // 创建并启动生产者线程
        Thread producerThread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is producing...");
                TimeUnit.SECONDS.sleep(2);
                String producerData = "Data from Producer";
                System.out.println(Thread.currentThread().getName() + " produced: " + producerData);
                String consumerData = exchanger.exchange(producerData);
                System.out.println(Thread.currentThread().getName() + " received: " + consumerData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer");

        // 创建并启动消费者线程
        Thread consumerThread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is consuming...");
                TimeUnit.SECONDS.sleep(1);
                String consumerData = "Data from Consumer";
                System.out.println(Thread.currentThread().getName() + " consumed: " + consumerData);
                String producerData = exchanger.exchange(consumerData);
                System.out.println(Thread.currentThread().getName() + " received: " + producerData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}