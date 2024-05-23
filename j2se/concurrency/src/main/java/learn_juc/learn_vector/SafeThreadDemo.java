package learn_juc.learn_vector;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SafeThreadDemo implements Runnable {

    private final Vector<Integer> vector = new Vector<>();

    private static final SafeThreadDemo demo = new SafeThreadDemo();

    private final Random random = new Random();

    @SneakyThrows
    @Override
    public void run() {
        int last = random.nextInt(10000);
        vector.add(last);
        TimeUnit.SECONDS.sleep(1);
        log.info("thread-{},add {},get last is {}", Thread.currentThread().getName(), last, vector.get(vector.size() - 1));
    }

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            new Thread(demo).start();
        }
    }

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(new Thread(demo));
        }
    }

}
