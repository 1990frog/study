package learn_juc.learn_blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {

    private static final LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        Thread main = Thread.currentThread();

        Thread daemonDemo = new Thread(() -> {
            while (true) {
                if (main.getState() == Thread.State.BLOCKED || main.getState() == Thread.State.WAITING) {
                    main.interrupt();
                }
            }
        });
        daemonDemo.setDaemon(true);
        daemonDemo.start();

        try {
            queue.take();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
            throw new RuntimeException(e);
        }

    }

}
