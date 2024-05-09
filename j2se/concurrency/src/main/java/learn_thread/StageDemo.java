package learn_thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class StageDemo implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        if ("RUNNABLE".equals(Thread.currentThread().getName())) {
            while (true) {

            }
        } else if ("BLOCKED".equals(Thread.currentThread().getName())) {
            synchronized (this) {
                TimeUnit.SECONDS.sleep(5);
            }
        } else if ("WAITING".equals(Thread.currentThread().getName())) {
            synchronized (this){
                wait();
            }
        } else if ("TIMED_WAITING".equals(Thread.currentThread().getName())) {
            synchronized (this){
                wait(5000);
            }
        }
    }

    @Test
    public void NEW() {
        Thread thread = new Thread(this, "NEW");
        log.info("thread stage is {}", thread.getState());
    }


    @Test
    public void RUNNABLE() throws InterruptedException {
        Thread thread = new Thread(this, "RUNNING");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        log.info("thread stage is {}", thread.getState());
    }

    @Test
    public void BLOCKED() throws InterruptedException {
        Thread t1 = new Thread(this, "BLOCKED");
        Thread t2 = new Thread(this, "BLOCKED");
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(3);
        log.info("thread stage is {}", t2.getState());
    }

    @Test
    public void WAITING() throws InterruptedException {
        Thread t1 = new Thread(this, "WAITING");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.info("thread stage is {}", t1.getState());
    }

    @Test
    public void TIMED_WAITING() throws InterruptedException {
        Thread t1 = new Thread(this, "TIMED_WAITING");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.info("thread stage is {}", t1.getState());
    }

    @Test
    public void TERMINATED() throws InterruptedException {
        Thread t1 = new Thread(this, "TERMINATED");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.info("thread stage is {}", t1.getState());
    }

}
