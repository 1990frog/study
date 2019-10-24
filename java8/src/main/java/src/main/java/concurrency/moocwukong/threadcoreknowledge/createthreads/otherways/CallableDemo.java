package src.main.java.concurrency.moocwukong.threadcoreknowledge.createthreads.otherways;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(5000);
        return "the thread is stop!";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FutureTask实现了Runnable接口
        FutureTask futureTask = new FutureTask(new CallableDemo());
        Thread thread = new Thread(futureTask);
        thread.start();
        thread.interrupt();
        String value = (String) futureTask.get();
        System.out.println(value);
    }
}
