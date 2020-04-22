package javase.base.concurrency.core.synchronizedlock;

/**
 * 方法抛出异常后，会释放锁
 */
public class SynchronizedException9 implements Runnable {

    static SynchronizedException9 instance = new SynchronizedException9();

    public synchronized void method1(){
        System.out.println("我是异常方法method1，我叫"+Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
            throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("我是异常方法method11，我叫"+Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public synchronized void method3(){
        System.out.println("我是加锁的方法method2，我叫"+Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method2();
        }else {
            method3();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        System.out.println("finished");
    }
}
