package learn_interrupt;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Demo1 implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("This thread is not interrupted");
        }
        System.out.println("This thread is interrupted");
    }

    @SneakyThrows
    public static void main(String[] args) {
        Thread thread = new Thread(new Demo1());
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
    }
}
