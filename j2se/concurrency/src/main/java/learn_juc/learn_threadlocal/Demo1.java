package learn_juc.learn_threadlocal;

import org.slf4j.Logger;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 implements Runnable {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Demo1.class);

    @Override
    public void run() {
        Random threadLocalRandom = Share.random.get();
        log.info("Thread is id {}, Class id is {}, value is {}", Thread.currentThread().getId(), threadLocalRandom.hashCode(), threadLocalRandom.nextInt(100));
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.execute(new Demo1());
        }
        executor.shutdown();
    }
}

class Share {
    public static ThreadLocal<Random> random = ThreadLocal.withInitial(Random::new);
}
