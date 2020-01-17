package base.concurrency.moocwukong.juc.threadpool;

/**
 * 描述：不使用线程池，每个任务都单独启动一个线程
 */
public class EveryTaskOneThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("执行了任务");
        }
    }

}
