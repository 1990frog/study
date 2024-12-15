package learn_interrupt.old;

import java.util.concurrent.TimeUnit;

public class ShutdownHookDemo implements Runnable {
    @Override
    public void run() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("this is shutdown hook")));
        Boolean isInterrupted = false;
        while (!isInterrupted) {
            isInterrupted = Thread.currentThread().isInterrupted();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ShutdownHookDemo());
        thread.start();
        TimeUnit.SECONDS.sleep(2);
//        thread.interrupt();
        System.exit(1);
    }


}
