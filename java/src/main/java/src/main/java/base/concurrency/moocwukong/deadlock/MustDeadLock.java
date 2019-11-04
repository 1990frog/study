package src.main.java.base.concurrency.moocwukong.deadlock;

/**
 * 描述：
 * 必定发生死锁的情况
 *
 * 当类的对象flag=1时（T1），先锁定O1，睡眠500毫秒，然后锁定O2；
 *
 * 而T1在睡眠的时候另一个flag=0的对象（T2）线程启动，先锁定O2，睡眠500毫秒，等待T1释放O1；
 *
 * T1睡眠结束后需要2锁定O2才能继续执行，而此时O2已被T2锁定；
 *
 * T2睡眠结束后需要锁定O1才能继续执行，而此时O1已被T1锁定；
 *
 * T1、T2相互等待，都需要对方锁定的资源才能继续执行，从而死锁。
 */
public class MustDeadLock implements Runnable {

    int flag = 1;

    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        MustDeadLock r1 = new MustDeadLock();
        MustDeadLock r2 = new MustDeadLock();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("线程1成功拿到两把锁");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("线程2成功拿到两把锁");
                }
            }
        }
    }
}
