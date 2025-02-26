package learn_thread;

import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class CreateThreadSample {

    private final Runnable runnable = () -> System.out.println("Hello World");
    private final Callable<String> callable = () -> "Hello World";

    @Test
    public void doCreateThread() {
        Thread thread = new Thread(runnable);
        // 调用 native start0 方法，创建新线程
        thread.start();
        // 调用方法，将当前线程与 run 绑定？
        thread.run();
        /**
         * start 方法调用两次 报错 抛出 IllegalThreadStateException
         * 第一次调用 start 方法，Thread.threadStatus 状况改变
         * synchronized (this) {
         *             // zero status corresponds to state "NEW".
         *             if (holder.threadStatus != 0)
         *                 throw new IllegalThreadStateException();
         *             start0();
         *         }
         */
        thread.start();
    }
}
