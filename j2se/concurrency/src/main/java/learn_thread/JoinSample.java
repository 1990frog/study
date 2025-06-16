package learn_thread;

import java.util.concurrent.TimeUnit;

/**
 * 底层 wait(0)
 */
public class JoinSample {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 start");
                t1.join();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2");

        Thread t3 = new Thread(() -> {
            try {
                System.out.println("t3 start");
                t2.join();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("t3 end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

        t3.join();
        System.out.println("end");
    }
}
