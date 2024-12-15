package learn_uncaughtexception;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.concurrent.*;

@Slf4j
public class UncaughtExceptionSample {

    @Test
    public void thread(){
        Thread thread = new Thread(()-> {
            throw new RuntimeException("runtime exception!");
        });
        thread.setUncaughtExceptionHandler((t, e) -> {
            log.error("{} have error!", t.getName());
            log.error(e.getMessage());
            // rollback
        });
        thread.start();
    }

    @Test
    public void execute(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.setThreadFactory(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDefaultUncaughtExceptionHandler((t, e) -> {
                    log.error("{} have error! : {}", t.getName(), e.getMessage());
                });
                return thread;
            }
        });
        for (int i = 0; i < 100; i++) {
            executor.execute(()-> {throw new RuntimeException("runtime exception!");});
        }
    }

    @Test
    public void submit(){

    }

}
