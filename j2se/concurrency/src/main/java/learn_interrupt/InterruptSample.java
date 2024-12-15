package learn_interrupt;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Slf4j
public class InterruptSample {

    /**
     * 响应中断，可以在catch中，或者finally中做回滚？
     *
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        Thread t1 = new Thread(()->{
            // run 方法不能抛出 InterruptedException,只有可中断的阻塞方法可以通过 throw 传递异常状态
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException ignore) {
            }
        });
        t1.start();
        t1.interrupt();
        TimeUnit.SECONDS.sleep(2);
        // 触发 InterruptedException 异常，interrupted 被重置
        log.info("t1 is interrupted {}", t1.isInterrupted());
        log.info("t1 is alice {}", t1.isAlive());
    }

    @Test
    public void test2() throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                while (!Thread.currentThread().isInterrupted()){

                }
                Thread.currentThread().interrupt();
                return "end!";
            }
        });
        Thread t2 = new Thread(futureTask);
        t2.start();
        t2.interrupt();
        TimeUnit.SECONDS.sleep(3);
        log.info("t2 is interrupted {}", t2.isInterrupted());
        log.info("t2 is alice {}", t2.isAlive());
        log.info("futureTask is done {}", futureTask.isDone());
    }
}
