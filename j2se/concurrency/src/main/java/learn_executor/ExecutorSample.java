package learn_executor;


import org.testng.annotations.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Executor 接口方法
 */
public class ExecutorSample {

    final static Executor executor = Executors.newSingleThreadExecutor();

    @Test
    public void execute() {
        // void execute(Runnable command);
        executor.execute(() -> System.out.println(Thread.currentThread().getName()));
    }

}
