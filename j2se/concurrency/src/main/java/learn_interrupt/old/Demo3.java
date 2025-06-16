package learn_interrupt.old;

import java.util.concurrent.*;

/**
 * 计时运行
 */
public class Demo3 {

    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(5);

    /**
     *
     * @param r
     * @param timeout
     * @param unit
     */
    public static void timedRun1(Runnable r, long timeout, TimeUnit unit){
        final Thread taskThread = Thread.currentThread();
        cancelExec.schedule(taskThread::interrupt, timeout, unit);
        r.run();
    }


    public static void timedRun2(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        class ReturnThrowableTask implements Runnable {
            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                }catch (Throwable t){
                    this.t = t;
                }
            }

            void rethrow() {
                if (t != null) {
                    throw launderThrowable(t);
                }
            }
        }

        ReturnThrowableTask task = new ReturnThrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(taskThread::interrupt, timeout, unit);
        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }

    public static void timedRun3(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        Future<?> task = cancelExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            // 
            task.cancel(true);
        }

    }

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException)
            return (RuntimeException) t;
        else if (t instanceof Error)
            throw (Error) t;
        else
            throw new IllegalStateException("Not unchecked", t);
    }

}
