package learn_executor;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFactoryMethodSample {

    @Test
    public void fixedThreadPoolTest(){
        ExecutorService executor = Executors.newFixedThreadPool(5);
    }

    @Test
    public void singleThreadPoolTest(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
    }

    @Test
    public void cachedThreadPoolTest(){
        ExecutorService executor = Executors.newCachedThreadPool();
    }

    @Test
    public void scheduledThreadPoolTest(){
        ExecutorService executor = Executors.newScheduledThreadPool(5);
    }

}
