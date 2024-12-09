package learn_executor;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllAndAnySample {

    static final ExecutorService executor = Executors.newFixedThreadPool(5);

    @Test
    public void invokeAll() throws ExecutionException, InterruptedException {
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable<String> callable;
            if (i == 0) {
                callable = () -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        return "5 seconds task";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
            } else {
                callable = () -> {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                        return "100 seconds task";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
            }
            tasks.add(callable);
        }
        String ret = executor.invokeAny(tasks);
        System.out.println(ret);
    }

}
