package createthread;

import org.testng.annotations.Test;

public class JoinDemo {

    @Test
    public void useJoin() throws InterruptedException {
        System.out.println("start !");
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 start !");
                Thread.sleep(1000);
                System.out.println("t1 end !");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 start !");
                Thread.sleep(1000);
                System.out.println("t2 end !");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("end !");
    }

    @Test
    public void notJoin() {
        System.out.println("start !");
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 start !");
                Thread.sleep(1000);
                System.out.println("t1 end !");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 start !");
                Thread.sleep(1000);
                System.out.println("t2 end !");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        System.out.println("end !");
    }


}
