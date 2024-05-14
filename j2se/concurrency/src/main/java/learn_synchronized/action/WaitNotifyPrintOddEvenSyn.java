package learn_synchronized.action;

/**
 * 描述：
 * 两个线程交替打印0~100的奇偶数，用synchronized关键字实现
 *
 * 效率低，有很多废操作
 */
public class WaitNotifyPrintOddEvenSyn {

    private static int count;

    private static final Object lock = new Object();

    //新建2个线程
    //1个只处理偶数，第二个只处理奇数（用位运算）
    //用synchronized来通信
    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                /**
                 * 这不是可重入锁
                 *
                 * 可重入锁的主要目的是解决在递归调用或嵌套代码中的锁定问题。
                 * 当一个线程已经获得了锁，但在持有锁的代码块中又调用了另一个需要同样锁的方法时，如果使用非可重入锁，线程会因为无法再次获得同一个锁而陷入死锁状态。
                 * 而可重入锁允许线程多次获得同一个锁，避免了死锁问题。
                 */
                synchronized (lock) {
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "偶数").start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "奇数").start();
    }
}
