package learn_executor;


import org.testng.annotations.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Executor 接口方法
 */
public class ExecutorSample {

    @Test
    public void execute(){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }

}
