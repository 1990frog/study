package learn_juc.learn_blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 基于数组实现的有界阻塞队列，ArrayBlockingQueue内部维护这一个定长数组，阻塞队列的大小在初始化时就已经确定了，其后无法更改。
 *
 * ArrayBlockingQueue支持公平性和非公平性，默认采用非公平模式，可以通过构造函数设置为公平访问策略。
 */
@Slf4j
public class ArrayBlockingQueueDemo {

    private static final Random random = new Random();

    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                int production = random.nextInt(100);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    queue.put(production);
                    log.info("production {}", production);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }


        new Thread(() -> {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    int consumer = queue.take();
                    log.info("consumer {}", consumer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
