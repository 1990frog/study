package learn_thread;

import java.util.concurrent.TimeUnit;

public class ThreadGroupSample {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("ThreadGroupSample");
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(tg, () -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t1.start();
        }
        while (tg.activeCount() > 0) {
            System.out.println(tg.activeCount());
        }
//        tg.interrupt();
    }
}
