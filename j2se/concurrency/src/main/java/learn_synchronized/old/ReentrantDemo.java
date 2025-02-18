package learn_synchronized.old;

public class ReentrantDemo implements Runnable {

    private Integer num = 0;

    @Override
    public void run() {
        method1();
    }

    public synchronized void method1() {
        num++;
        if (num < 100) {
            method2();
        }
    }

    public synchronized void method2() {
        num++;
        if (num < 100) {
            method1();
        }
    }

    public static void main(String[] args) {
        ReentrantDemo demo = new ReentrantDemo();
        Thread thread = new Thread(demo);
        thread.start();
        while (thread.isAlive()) {
        }
        System.out.println(demo.num);
        System.out.println(thread.getState());
    }
}
