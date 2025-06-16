package learn_interrupt.old;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class WhileSample {

    static boolean interrupted = false;

    static BlockingDeque<String> queue = new LinkedBlockingDeque<>();

    static Runnable runnable = new Runnable() {
        public void run() {
            try{
                while(true){
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    }
                }
            } finally {
                if(interrupted){
                    Thread.currentThread().interrupt();
                }
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(runnable);
        t.start();
        TimeUnit.SECONDS.sleep(3);
        t.interrupt();
        System.out.println(interrupted);
    }
}