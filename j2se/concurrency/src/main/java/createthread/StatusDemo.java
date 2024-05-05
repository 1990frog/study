package createthread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StatusDemo {

    public static synchronized void synchronizedMethod() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void blocked2runnable() throws InterruptedException {
        Thread thread1 = new Thread(StatusDemo::synchronizedMethod, "t1");
        Thread thread2 = new Thread(StatusDemo::synchronizedMethod, "t2");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.start();
        System.out.println("t1："+thread1.getState());
        System.out.println("t2："+thread2.getState());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("t1："+thread1.getState());
        System.out.println("t2："+thread2.getState());
    }

    @SneakyThrows
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(4 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(1 * 1000);
        System.out.println(thread.getState());
        Thread.sleep(5 * 1000);
        System.out.println(thread.getState());
    }
}
