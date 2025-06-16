package learn_executor;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ExecutorService 接口方法
 * <p>
 * public interface ExecutorService extends Executor, AutoCloseable
 */
public class ExecutorServiceSample {

    static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    @Test
    public void shutdown() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                    System.out.println("sleep : " + finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(100,TimeUnit.SECONDS);
        System.out.println("executorService is shutdown");
    }

    @Test
    public void shutdownNow() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                    System.out.println("sleep : " + finalI);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "is interrupted！");
                    throw new RuntimeException(e);
                }
            });
        }
        List<Runnable> ret = executorService.shutdownNow();
        System.out.println(ret.size());
        executorService.awaitTermination(100,TimeUnit.SECONDS);
        System.out.println("executorService is shutdown");
    }

    @Test
    public void isShutdown() {
        System.out.println(executorService.isShutdown());
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
    }

    @Test
    public void isTerminated() {
        System.out.println(executorService.isShutdown());
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }

    @Test
    public void awaitTermination() throws InterruptedException {
        executorService.execute(()-> {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
        boolean isTerminated = executorService.awaitTermination(1,TimeUnit.SECONDS);
        System.out.println("executorService is terminated: "+ isTerminated);
    }

    @Test
    public void submit() throws ExecutionException, InterruptedException {
        // Future<?> submit(Runnable task);
        Future submit1 = executorService.submit(() -> System.out.println("submit1"));
        // <T> Future<T> submit(Runnable task, T result);
        Future submit2 = executorService.submit(() -> System.out.println("submit2"), "submit2");
        // <T> Future<T> submit(Callable<T> task);
        Future<String> submit3 = executorService.submit(() -> "submit3");

        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());
    }

    /**
     * 所有提交的任务执行完成之后返回全部的 future，只调用一次的业务情景
     *
     * @throws InterruptedException
     */
    @Test
    public void invokeAll() throws InterruptedException {
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable<String> callable;
            if (i == 0) {
                callable = () -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        return "5 seconds task";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
            } else {
                callable = () -> {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                        return "100 seconds task";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
            }
            tasks.add(callable);
        }
        List<Future<String>> ret = executorService.invokeAll(tasks);
        ret.forEach(System.out::println);
    }

    /**
     * 成功一个就返回
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void invokeAny() throws ExecutionException, InterruptedException {
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable<String> callable;
            if (i == 0) {
                callable = () -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        return "5 seconds task";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
            } else {
                callable = () -> {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                        return "100 seconds task";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
            }
            tasks.add(callable);
        }
        String ret = executorService.invokeAny(tasks);
        System.out.println(ret);
    }

}
