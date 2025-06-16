package learn_threadsafe.deadlock;

import java.util.concurrent.*;

/**
 * 饥饿死锁
 *
 * 每当提交了一个有依赖性的 Executor 任务时，要清楚地知道可能出现线程“饥饿”死锁，因此需要再代码或配置 Executor 的配置文件中记录线程池的大小限制或配置限制。
 */
public class Demo1 implements Callable<String> {

    private static ExecutorService exec = Executors.newSingleThreadExecutor();

    @Override
    public String call() throws Exception {
        Future<String> t1 = exec.submit(new Demo1());
        Future<String> t2 = exec.submit(new Demo1());
        return t1.get() + t2.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = exec.submit(new Demo1());
        System.out.println(future.get());
//        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
