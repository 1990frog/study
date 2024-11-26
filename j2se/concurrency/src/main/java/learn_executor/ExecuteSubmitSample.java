package learn_executor;

import org.testng.annotations.Test;

import java.util.concurrent.*;

public class ExecuteSubmitSample {

    @Test
    public void execute() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // execute 方法源于 Executor 接口，参数 Runnable
        executor.execute(() -> System.out.println("Hello World"));
    }

    @Test
    public void submit1() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future future = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        while (!future.isDone()) {
            System.out.println("future1 is not Done");
        }
        System.out.println("future1 isDone");
    }

    @Test
    public void submit2() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("running!");
            }
        }, "Hello World");
        System.out.println(future.get());
    }

    @Test
    public void submit3() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello World";
            }
        });
        System.out.println(future.get());
    }
}
