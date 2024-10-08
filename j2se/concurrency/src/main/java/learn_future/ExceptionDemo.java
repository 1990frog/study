package learn_future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ExceptionDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        if (new Random().nextBoolean()) {
            throw new Exception("任务执行失败");
        }
        return "任务成功";
    }

    public static void main(String[] args) {
        FutureTask<String> future = new FutureTask<>(new ExceptionDemo());
        Thread thread = new Thread(future);
        thread.start();
        try {
            String result = future.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            System.out.println("任务抛出异常: " + e.getCause());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
