package learn_synchronized;

/**
 * 描述：
 * 3个线程，线程1和线程2首先被阻塞，
 * 线程3唤醒它们。
 * notify, notifyAll。
 * start先执行不代表线程先启动。
 */
public class WaitNotifyAllDemo implements Runnable {

    private static final Object resourceA = new Object();


    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAllDemo();
        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);
        Thread threadC = new Thread(() -> {
            synchronized (resourceA) {
                resourceA.notifyAll();
//                    resourceA.notify();
                System.out.println("ThreadC notified.");
            }
        });
        threadA.start();
        threadB.start();
//        Thread.sleep(200);
        threadC.start();
    }
    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName()+" got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName()+" waits to start.");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+"'s waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
