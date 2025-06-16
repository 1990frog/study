package learn_interrupt.old;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class InterruptSample implements Runnable {

    @Override
    public void run() {
        // 获取线程的 isInterrupted 状态
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("This thread is not interrupted");
            // 检测当前的中断状态，并清除
            System.out.println(Thread.interrupted());
        }
        System.out.println("This thread is interrupted");
    }

    @SneakyThrows
    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptSample());
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        // 将线程 isInterrupted 状态设置为 false
        thread.interrupt();
    }
}
