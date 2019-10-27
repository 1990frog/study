package src.main.java.concurrency.moocwukong.synchronizedlock;

public class SynchronizedObjectCodeBlock2 implements Runnable {

    Object lock1 = new Object();
    Object lock2 = new Object();

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    @Override
    public void run() {

        synchronized (lock1){
            System.out.println("我是lock1。我叫"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock1运行结束");
        }

        synchronized (lock2){
            System.out.println("我是lock2。我叫"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock2运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}
