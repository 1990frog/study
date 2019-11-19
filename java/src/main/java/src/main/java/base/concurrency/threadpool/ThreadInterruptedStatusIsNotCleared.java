package src.main.java.base.concurrency.threadpool;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Thread interrupted status is not cleared when InterruptedException is thrown
 */
public class ThreadInterruptedStatusIsNotCleared {

    /**
     * public void shutdown() {
     *         final ReentrantLock mainLock = this.mainLock;
     *         mainLock.lock();
     *         try {
     *             checkShutdownAccess();
     *             advanceRunState(SHUTDOWN);
     *             interruptIdleWorkers();
     *             onShutdown(); // hook for ScheduledThreadPoolExecutor
     *         } finally {
     *             mainLock.unlock();
     *         }
     *         tryTerminate();
     *     }
     */
    public static void test1() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000 * 100);
                } catch (InterruptedException e) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupted");
                    }
                }
            });
        }
        executor.shutdownNow();
        executor.awaitTermination(5,TimeUnit.SECONDS);
    }

    public static void test2() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
//            test1();
            test3();
        }
    }


    /**
     * public void interrupt() {
     *         if (this != Thread.currentThread())
     *             checkAccess();
     *
     *         synchronized (blockerLock) {
     *             Interruptible b = blocker;
     *             if (b != null) {
     *                 interrupt0();           // Just to set the interrupt flag
     *                 b.interrupt(this);
     *                 return;
     *             }
     *         }
     *         interrupt0();
     *     }
     */
    public static void test3() {
        ArrayList<Thread> pool = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000 * 100);
                } catch (InterruptedException e) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupted");
                    }
                }
            });
            pool.add(thread);
            thread.start();
        }
        pool.stream().forEach(n->n.interrupt());
    }

    public static void main(String[] args) throws InterruptedException {
        test3();
    }
}
