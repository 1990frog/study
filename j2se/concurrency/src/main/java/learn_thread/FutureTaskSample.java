package learn_thread;

import org.testng.annotations.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskSample {

    private final Runnable runnable = () -> {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    };

    private final Callable<String> callable = () -> {
        TimeUnit.SECONDS.sleep(3);
        return "hello callable";
    };

    @Test
    public void runnableTest() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(runnable, "true");
        Thread thread = new Thread(futureTask);
        thread.start();
        String result = futureTask.get();
        System.out.println(result);
    }

    @Test
    public void runnableErrorTest() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(runnable, "true");
        Thread thread = new Thread(futureTask);
        thread.start();
        thread.interrupt();
        String result = futureTask.get();
        System.out.println(result);
    }

    @Test
    public void callableTest() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        String result = futureTask.get();
        System.out.println(result);
    }


}
