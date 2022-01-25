import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiterDemo implements Runnable {

    public RateLimiter limiter = RateLimiter.create(10,1, TimeUnit.SECONDS);
    public AtomicInteger integer = new AtomicInteger(0);

    @Override
    public void run() {
        limiter.acquire(10);
        System.out.println(integer.incrementAndGet());
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        RateLimiterDemo rateLimiterDemo = new RateLimiterDemo();
        for (int i = 0; i < 100; i++) {
            executorService.submit(rateLimiterDemo);
        }
        executorService.shutdown();
        while (executorService.isTerminated()){
            System.out.println("end!");
        }
    }
}
