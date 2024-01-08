package juc.lock.reentrantlock;

public class WorkerTest implements Runnable {

    static Worker lock = new Worker();

    public void foo(){
        try{
            lock.lock();
            System.out.println("foo");
            bar();
        }finally {
            lock.unlock();
        }
    }

    public void bar(){
        try{
            lock.lock();
            System.out.println("bar");
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        foo();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NonReentrantDeadLockEffect());
//        Thread thread2 = new Thread(new NonReentrantDeadLockEffect());
        thread1.start();
//        thread2.start();
    }

}
