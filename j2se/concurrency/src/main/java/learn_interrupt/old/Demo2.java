package learn_interrupt.old;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Demo2 implements Runnable{
    @Override
    public void run() {
        boolean interrupted = Thread.currentThread().isInterrupted();
        while (!interrupted){
            try {
                blockingMethod();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                interrupted = Thread.currentThread().isInterrupted();
            }
        }
    }

    public void blockingMethod() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread(new Demo2());
        t1.start();
        TimeUnit.SECONDS.sleep(3);
        t1.interrupt();
    }
}
