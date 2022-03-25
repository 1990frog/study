package juc.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/3/25
 */
public class FutureTaskDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task1 = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return 10;
        });
        FutureTask<Integer> task2 = new FutureTask<>(() -> {
            Thread.sleep(2000);
            return 20;
        });

        new Thread(task1).start();
        new Thread(task2).start();

        while (!task1.isDone() || !task2.isDone()){

        }

    }
}
