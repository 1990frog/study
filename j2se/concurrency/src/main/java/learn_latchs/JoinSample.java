package learn_latchs;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JoinSample implements Runnable {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    private static Thread main = Thread.currentThread();

    @Override
    public void run() {
        try {
            main.join();
            System.out.println(Thread.currentThread().getName()+" is running");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            executor.execute(new JoinSample());
        }
        executor.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Main thread exiting");
    }


    @Test
    public void test1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            executor.execute(new JoinSample());
        }
        executor.shutdown();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("Main thread exiting");
    }
}
