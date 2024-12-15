package learn_executor;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExecutorsSample {

    /**
     * new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
     */
    @Test
    public void newFixedThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        List<Runnable> list = executorService.shutdownNow();
        log.info("size {}", list.size());
    }

    @Test
    public void newWorkStealingPool(){

    }

    /**
     * new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory)
     */
    @Test
    public void newSingleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            log.info(Thread.currentThread().getName());
        });
    }

    /**
     * new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>())
     */
    @Test
    public void newCachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
    }

    /**
     * new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE,
     *               DEFAULT_KEEPALIVE_MILLIS, MILLISECONDS,
     *               new DelayedWorkQueue())
     */
    @Test
    public void newScheduledThreadPool(){
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
    }
}
