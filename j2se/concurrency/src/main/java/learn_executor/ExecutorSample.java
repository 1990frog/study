package learn_executor;


import org.testng.annotations.Test;

import java.util.concurrent.*;

public class ExecutorSample {

    /**
     * 几种默认线程池工厂方法创建
     */
    public void defaultFactoryMethod() {
        // FixedThreadPool
        int nThreads = 10;
        ExecutorService fixedThreadPool1 = Executors.newFixedThreadPool(nThreads);
        ExecutorService fixedThreadPool2 = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        // SingleThreadExecutor
        ExecutorService singleThreadExecutor1 = Executors.newSingleThreadExecutor();
        ExecutorService singleThreadExecutor2 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        // CachedThreadPool
        ExecutorService cachedThreadPool1 = Executors.newCachedThreadPool();
        ExecutorService cachedThreadPool2 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>());

        // ScheduledThreadPool
        int corePoolSize = 10;
        long DEFAULT_KEEPALIVE_MILLIS = 10L;
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(corePoolSize);
//        ExecutorService scheduledThreadPool = new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, DEFAULT_KEEPALIVE_MILLIS, TimeUnit.MILLISECONDS, new ScheduledThreadPoolExecutor.DelayedWorkQueue<>());
    }

    public void execute(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // execute 方法源于 Executor 接口，参数 Runnable
        executor.execute(() -> System.out.println("Hello World"));
    }

    @Test
    public void submit1(){
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

    public void shutdown(){

    }

    public void shutdownNow(){

    }

    public void awaitTermination(){

    }

    public void isTerminated(){

    }

    public void invokeAll(){

    }

    public void newTaskFor(){

    }

    public void executorCompletionService(){

    }


}
