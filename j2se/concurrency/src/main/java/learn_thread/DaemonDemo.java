package learn_thread;

import java.util.concurrent.TimeUnit;

public class DaemonDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 开始运行, " +
                    (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            // t1线程死循环！
            while (true) {

            }
        }, "t1");
        
        // 如果t1不是守护线程，则t1与main独立，main结束t1还不会结束（还在while(true)里），
        // 如果t1是守护线程，那么main主线程结束，t1也会结束
        // setDaemon()方法必须在start()方法前设置，否则报错
        t1.setDaemon(true);
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t -----end 主线程");
    }
}