package learn_executor;

import org.testng.annotations.Test;

import java.util.concurrent.*;

public class ExecutorSample {

    @Test
    public void testExecute() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Hello World"));
        executor.shutdownNow();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(executor.isTerminated());
    }

    @Test
    public void testSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(()-> System.out.println("Hello World"));
        System.out.println(future.get());
    }

}
