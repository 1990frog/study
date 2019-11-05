package src.main.java.base.concurrency.tasktimeout;

public class DemonThread implements Runnable {

    private int time;

    public DemonThread(int t) {
        time = t;
    }

    public void run() {
        for (int i = 0; i < time; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted when calculating, will stop...");
                return; // 注意这里如果不return的话，线程还会继续执行，所以任务超时后在这里处理结果然后返回
            }
            System.out.println(Thread.currentThread().getName() + " " + (i + 1) + " round");
        }
        System.out.println(Thread.currentThread().getName() + " finished successfully");
    }

    public static void main(String[] args) {
        DemonThread task1 = new DemonThread(5);
        Thread t1 = new Thread(task1);
        Daemon daemon = new Daemon(t1, 3);
        Thread daemoThread = new Thread(daemon);
        daemoThread.setDaemon(true);
        t1.start();
        daemoThread.start();
    }

}

class Daemon implements Runnable {

    private Thread thread;
    private int time;

    public Daemon(Thread r, int t) {
        thread = r;
        time = t;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        }
    }

}
