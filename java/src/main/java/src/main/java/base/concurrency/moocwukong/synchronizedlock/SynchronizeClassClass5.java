package src.main.java.base.concurrency.moocwukong.synchronizedlock;

public class SynchronizeClassClass5 implements Runnable{

    static SynchronizeClassClass5 instance1 = new SynchronizeClassClass5();
    static SynchronizeClassClass5 instance2 = new SynchronizeClassClass5();

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void method() throws InterruptedException {
        synchronized (SynchronizeClassClass5.class){
            System.out.println("我是类锁的第二种形式：synchronized（*.class）。我叫"+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("结束");
    }
}
