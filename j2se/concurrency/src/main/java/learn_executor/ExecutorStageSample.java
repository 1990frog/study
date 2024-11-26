package learn_executor;

import org.testng.annotations.Test;

import java.util.concurrent.*;

/**
 * （1）RUNNING：接收新的任务，并对任务队列里的任务进行处理；
 * （2）SHUTDOWN：不再接收新的任务，但是会对任务队列中的任务进行处理；
 * （3）STOP：不接收新任务，也不再对任务队列中的任务进行处理，并中断正在处理的任务；
 * （4）TIDYING：所有任务都已终止，线程数为0，在转向TIDYING状态的过程中，线程会执行terminated()钩子方法，钩子方法是指在本类中是空方法，而在子类中进行具体实现的方法；
 * （5）TERMINATED：terminated()方法执行结束后会进入这一状态，表示线程池已关闭。
 */
public class ExecutorStageSample {

    enum State {
        // 程池接受新任务并处理队列中的任务
        RUNNING,
        // 不再接受新任务，但会处理队列中的任务
        SHUTDOWN,
        // 不再接受新任务，不处理队列中的任务，中断正在执行的任务
        STOP,
        // 所有任务都已终止，工作线程数量为0，将要调用terminated()
        TIDYING,
        // terminated()被调用，线程池终止状态
        TERMINATED
    }

    /**
     * RUNNING -> SHUTDOWN  (调用 shutdown())
     * RUNNING -> STOP      (调用 shutdownNow())
     * SHUTDOWN -> TIDYING  (任务队列和线程池中所有任务执行完成)
     * STOP -> TIDYING      (线程池中的所有任务终止)
     * TIDYING -> TERMINATED (调用 terminated() 方法)
     */
    @Test
    public void stage() {
        // 初始状态为 RUNNING
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 线程池状态由 RUNNING 转换为 SHUTDOWN
        executor.shutdown();
        // 线程池状态由 RUNNING 转换为 STOP
        executor.shutdownNow();
        // 当线程池状态为 SHUTDOWN，且任务队列为空，正在执行的任务也执行完毕时，线程池会进入 TIDYING 状态。
        // 当线程池状态为 STOP，且任务队列为空，所有线程已终止时，线程池会进入 TIDYING 状态。
        // TIDYING 状态表示线程池的所有任务都已终止，活动线程数量为 0。此时，线程池即将进入 TERMINATED 状态。
        // TERMINATED 状态表示线程池已经彻底关闭，所有的任务都已完成，所有的工作线程都已被销毁。
    }

    @Test
    public void shutdown() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> System.out.println("任务" + finalI + "IS RUNNING"));
        }
        executor.shutdown();
    }

    @Test
    public void shutdownNow() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> System.out.println("任务" + finalI + "IS RUNNING"));
        }
        executor.shutdownNow();
    }

    /**
     * isTerminated()
     * state >= TERMINATED
     */
    @Test
    public void isTerminated() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> System.out.println("任务" + finalI + "IS RUNNING"));
        }
        while (!executor.isTerminated()) {
            executor.shutdownNow();
            System.out.println("任务没有终止！");
        }
        System.out.println("任务终止！");
    }

    /**
     * isShutdown()
     * state >= SHUTDOWN
     */
    @Test
    public void isShutdown() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> System.out.println("任务" + finalI + "IS RUNNING"));
        }
        while (!executor.isShutdown()) {
            executor.shutdownNow();
            System.out.println("state < SHUTDOWN");
        }
        System.out.println("state >= SHUTDOWN");
        while (!executor.isTerminated()) {
            executor.shutdownNow();
            System.out.println("state < TERMINATED");
        }
        System.out.println("state >= TERMINATED");
    }

    /**
     * awaitTermination()
     * state >= TERMINATED
     */
    @Test
    public void awaitTermination() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> System.out.println("任务" + finalI + "IS RUNNING"));
        }
        System.out.println("state < TERMINATED");
        executor.shutdown();
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("state < TERMINATED");
        }
        System.out.println("state >= TERMINATED");
    }

}

















