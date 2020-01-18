package base.concurrency.mydemo.tasktimeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AwaitTermination implements Runnable {

    private int time;

    public AwaitTermination(int time) {
        this.time = time;
    }

    public void run() {
        for (int i = 0; i < time; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted when calculating, will stop...");
                return; // 注意这里如果不return的话，线程还会继续执行，所以任务超时后在这里处理结果然后返回
            }
            System.out.println(Thread.currentThread().getName()  + " " + (i + 1) + " round");
        }
        System.out.println(Thread.currentThread().getName() + " finished successfully");
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        AwaitTermination task1 = new AwaitTermination(5);
        AwaitTermination task2 = new AwaitTermination(2);
        Future<?> future = executor.submit(task1);
        Future<?> future2 = executor.submit(task2);

        List<Future<?>> futures = new ArrayList<>();
        futures.add(future);
        futures.add(future2);

        try {
            if (executor.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("task finished");
            } else {
                System.out.println("task time out,will terminate");
                for (Future<?> f : futures) {
                    if (!f.isDone()) {
                        f.cancel(true);
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("executor is interrupted");
        } finally {
            executor.shutdown();
        }
    }
}