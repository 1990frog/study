package learn_future;

import java.util.concurrent.*;

public class InterruptDemo implements Runnable {

    private static ExecutorService exec = Executors.newSingleThreadExecutor();

    @Override
    public void run() {
        int i = 0;
        boolean isInterrupted = false;
        while (!isInterrupted){
            System.out.println(i++);
            isInterrupted = Thread.currentThread().isInterrupted();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Future future = exec.submit(new InterruptDemo());
        try {
            future.get(2, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            future.cancel(true);
        }
    }
}
