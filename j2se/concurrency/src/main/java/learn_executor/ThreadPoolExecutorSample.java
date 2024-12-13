package learn_executor;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * （1）RUNNING：接收新的任务，并对任务队列里的任务进行处理；
 * （2）SHUTDOWN：不再接收新的任务，但是会对任务队列中的任务进行处理；
 * （3）STOP：不接收新任务，也不再对任务队列中的任务进行处理，并中断正在处理的任务；
 * （4）TIDYING：所有任务都已终止，线程数为 0，在转向 TIDYING 状态的过程中，线程会执行 terminated() 钩子方法，钩子方法是指在本类中是空方法，而在子类中进行具体实现的方法；
 * （5）TERMINATED：terminated() 方法执行结束后会进入这一状态，表示线程池已关闭。
 */
@Slf4j
public class ThreadPoolExecutorSample {


    @Test
    public void state() {
        final int COUNT_BITS = Integer.SIZE - 3;
        final int COUNT_MASK = (1 << COUNT_BITS) - 1;
        // runState is stored in the high-order bits
        final int RUNNING = -1 << COUNT_BITS;
        final int SHUTDOWN = 0 << COUNT_BITS;
        final int STOP = 1 << COUNT_BITS;
        final int TIDYING = 2 << COUNT_BITS;
        final int TERMINATED = 3 << COUNT_BITS;

        // 初始状态为 RUNNING
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        System.out.println("state <= RUNNING");
        System.out.println(RUNNING);
        // 线程池状态由 RUNNING 转换为 SHUTDOWN
        executor.shutdown();
        System.out.println("state <= SHUTDOWN");
        System.out.println(SHUTDOWN);
        // 线程池状态由 RUNNING 转换为 STOP
        executor.shutdownNow();
        // 当线程池状态为 SHUTDOWN，且任务队列为空，正在执行的任务也执行完毕时，线程池会进入 TIDYING 状态。
        // 当线程池状态为 STOP，且任务队列为空，所有线程已终止时，线程池会进入 TIDYING 状态。
        // TIDYING 状态表示线程池的所有任务都已终止，活动线程数量为 0。此时，线程池即将进入 TERMINATED 状态。
        // TERMINATED 状态表示线程池已经彻底关闭，所有的任务都已完成，所有的工作线程都已被销毁。
    }

    @Test
    public void afterBeforeExecute() throws InterruptedException {

        class TimingThreadPool extends ThreadPoolExecutor {
            private final ThreadLocal<Long> startTime = new ThreadLocal<>();
            private final AtomicLong numTasks = new AtomicLong();
            private final AtomicLong totalTime = new AtomicLong();

            public TimingThreadPool() {
                super(1, 1, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                try {
                    long endTime = System.nanoTime();
                    long taskTime = endTime - startTime.get();
                    numTasks.incrementAndGet();
                    totalTime.addAndGet(taskTime);
                    log.info("Thread {}: end {}, time={}ns", t, r, totalTime.get() / numTasks.get());
                } finally {
                    super.afterExecute(r, t);
                }
            }

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                log.info("Thread {}: start {}", t, r);
                startTime.set(System.nanoTime());
            }
        }

        TimingThreadPool timingThreadPool = new TimingThreadPool();
        timingThreadPool.submit(() -> System.out.println("Thread " + Thread.currentThread().getId() + " started"));
        timingThreadPool.shutdown();
        if (timingThreadPool.awaitTermination(100, TimeUnit.SECONDS)) {
            System.out.println("end!");
        }
    }
}
