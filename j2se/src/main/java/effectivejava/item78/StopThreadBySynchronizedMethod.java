package effectivejava.item78;

import java.util.concurrent.TimeUnit;

/**
 * synchronized将变量压入主存，如果非synchronized读取数据，那么会从线程对应的内存读吗？
 *
 * synchronized：原子性、可见性、互斥性
 * 3个特性各自的意义
 *
 * 如果能保证原子性与可见性那么互斥锁意义是什么？
 * 互斥访问？
 */
public class StopThreadBySynchronizedMethod {

    private static boolean stopRequested;

    private static synchronized void requestStop(){
        stopRequested = true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(()->{
            int i=0;
            while (!stopRequested())
                i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
