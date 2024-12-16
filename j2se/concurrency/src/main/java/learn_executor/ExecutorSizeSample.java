package learn_executor;

import org.testng.annotations.Test;

public class ExecutorSizeSample {

    /**
     * 吃满一个线程
     */
    @Test
    public void oneThread() {
        //死循环，什么都不做
        while (true) {
        }
    }

    /**
     * 吃满全部线程
     */
    @Test
    public void maxThreads() {
        int size = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                while (true) {
                }
            }).start();
        }
    }

    public void test() {
        int size = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                while (true) {
                    //每次空循环 1亿 次后，sleep 50ms，模拟 I/O等待、切换
                    for (int j = 0; j < 100_000_000L; j++) {

                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        ExecutorSizeSample test = new ExecutorSizeSample();
        test.test();
    }

}
