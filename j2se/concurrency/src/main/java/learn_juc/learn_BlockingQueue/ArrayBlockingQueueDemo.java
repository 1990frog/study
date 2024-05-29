package learn_juc.learn_BlockingQueue;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

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
