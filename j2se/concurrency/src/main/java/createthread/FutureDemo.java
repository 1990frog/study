package createthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureDemo {

    public void futureTest() throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<>(() -> "hello future");
        new Thread(future).start();
        System.out.println(future.get());
    }

}
