package createthread;

import java.util.concurrent.TimeUnit;

public class StartDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
        thread.start();
    }
}
