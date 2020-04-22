package javase.base.concurrency.juc.threadpool.executorfactory;

import java.util.concurrent.*;

public class ReturnValue implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new ReturnValue());
        executorService.shutdown();
        System.out.println("future:"+future.get(2,TimeUnit.SECONDS));
        System.out.println("end！");

    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return "foo";
    }
}
