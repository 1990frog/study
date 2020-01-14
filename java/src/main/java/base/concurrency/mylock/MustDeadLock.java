package base.concurrency.mylock;

import java.util.concurrent.TimeUnit;

public class MustDeadLock {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void deadLock(int flag) {
        if(flag==1){
            synchronized (lock1){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("lock1——>lock2");
                }
            }
        }else {
            synchronized (lock2){
                synchronized (lock1){
                    System.out.println("lock1——>lock2");
                }
            }
        }
    }

    public static void main(String[] args) {
        MustDeadLock mustDeadLock = new MustDeadLock();
        new Thread(()->mustDeadLock.deadLock(1)).start();
        new Thread(()->mustDeadLock.deadLock(2)).start();
    }
}
