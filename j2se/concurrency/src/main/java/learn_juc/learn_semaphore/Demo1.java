package learn_juc.learn_semaphore;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>
 *
 * </p>
 *
 * @author caijingquan
 * @since 5/29/24
 */
public class Demo1 {

    private final Semaphore semaphore;

    private int num = 0;

    public Demo1() {
        semaphore = new Semaphore(1, true);
    }

    public void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    num++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println(num);
    }

    public void test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> num++);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println(num);
    }

    @SneakyThrows
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.test1();
        demo1.test2();
    }
}
