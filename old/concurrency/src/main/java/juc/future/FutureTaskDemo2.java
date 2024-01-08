package juc.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/3/25
 */
public class FutureTaskDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        FutureTask<Integer> task1 = new FutureTask<>(() -> {
            Thread.sleep(3000);
            return 10;
        });
        FutureTask<Integer> task2 = new FutureTask<>(() -> {
            Thread.sleep(3000);
            return 20;
        });

        new Thread(task1).start();
        new Thread(task2).start();

        task1.get(5, TimeUnit.SECONDS);
        task2.get(1, TimeUnit.SECONDS);

    }
}
