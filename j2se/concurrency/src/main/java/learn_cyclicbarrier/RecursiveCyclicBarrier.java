package learn_cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class RecursiveCyclicBarrier {

    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
    private static final CyclicBarrier BARRIER = new CyclicBarrier(THREAD_COUNT, () -> System.out.println("All threads reached barrier, continuing..."));

    private static void recursiveTask(int depth) throws Exception {
        if (depth >= 5) { // 递归深度
            // 执行到达 barrier 后的操作
            BARRIER.await();
            return;
        }

        // 执行递归任务
        System.out.println(Thread.currentThread()+" Depth: " + depth);

        // 等待其他线程
        BARRIER.await();
        recursiveTask(depth + 1);
    }

    public static void main(String[] args) {
        ExecutorService executor = newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(() -> {
                try {
                    recursiveTask(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
