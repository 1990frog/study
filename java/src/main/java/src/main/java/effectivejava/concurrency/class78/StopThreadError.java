package src.main.java.effectivejava.concurrency.class78;

import java.util.concurrent.TimeUnit;

/**
 * https://www.cnblogs.com/linghu-java/p/8589843.html
 * java虚拟机hoisting
 * jmm可见性
 */
public class StopThreadError {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(()->{
            int i=0;
            while (!stopRequested)
                i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
