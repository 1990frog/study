package learn_future;

import java.util.concurrent.*;

public class FutureDemo implements Callable<String> {


    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        return "end";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureDemo futureDemo = new FutureDemo();
        FutureTask<String> future = new FutureTask<>(futureDemo);
        new Thread(future).start();
        String msg = future.get();
        System.out.println(msg);
    }
}
