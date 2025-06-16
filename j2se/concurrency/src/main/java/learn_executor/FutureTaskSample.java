package learn_executor;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.concurrent.*;

/**
 * Future -> FutureRunnable -> FutureTask
 * <p>
 * interface RunnableFuture<V> extends Runnable, Future<V>
 */
@Slf4j
public class FutureTaskSample {

    private static final Callable<String> callable1 = Executors.callable(() -> System.out.println("hehe"), "hehe");
    private static final Callable<String> callable2 = () -> "hehe";
    private static final Callable<String> callable3 = () -> {
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
//                Thread.currentThread().interrupt();
        }
        return "hehe";
    };


    @Test
    public void cancel() throws InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(callable3);
        Thread thread = new Thread(futureTask);
        thread.start();
        futureTask.cancel(true);
        if (futureTask.isDone()) {
            System.out.println(thread.isInterrupted());
        }
        thread.join();
        System.out.println(futureTask.isCancelled());
        System.out.println(thread.getState());
        if(futureTask.isCancelled())
            System.out.println(thread.isInterrupted());
    }

    @Test
    public void isCancelled() throws InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(callable3);
        System.out.println(futureTask.state());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.state());
        thread.join();
        System.out.println(futureTask.state());
        System.out.println(futureTask.isDone());
    }

    @Test
    public void isDone() {

    }

    @Test
    public void get() {
        FutureTask<String> futureTask = new FutureTask<>(callable2);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void state(){

    }

    enum State {
        RUNNING,
        SUCCESS,
        FAILED,
        CANCELLED
    }


}
