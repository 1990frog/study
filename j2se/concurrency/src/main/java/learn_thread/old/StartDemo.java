package learn_thread.old;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class StartDemo implements Runnable {

    private final StartDemo instance = new StartDemo();

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void twiceStart(){
        Thread thread = new Thread(instance);
        log.info("status: {}", thread.getState());
        thread.start();
        log.info("status: {}", thread.getState());
        thread.start();
    }

    public void startAndRun(){
        Thread thread = new Thread(instance);
        thread.start();
        // 仅为调用方法
        thread.run();
    }

}
