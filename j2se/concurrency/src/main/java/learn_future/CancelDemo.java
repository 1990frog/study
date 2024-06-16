package learn_future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CancelDemo implements Runnable {

    private static final ExecutorService exec = Executors.newSingleThreadExecutor();

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Future future = exec.submit(new CancelDemo());
        TimeUnit.SECONDS.sleep(2);
        future.cancel(true);
        System.out.println(future.isCancelled());
    }
}
