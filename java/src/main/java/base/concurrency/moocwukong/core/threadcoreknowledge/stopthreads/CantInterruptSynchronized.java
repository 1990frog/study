package base.concurrency.moocwukong.core.threadcoreknowledge.stopthreads;

public class CantInterruptSynchronized {

    static Object obj = new Object();

//    public static synchronized void test() throws InterruptedException{
//        try {
//            for(;;);
//            System.out.println("synchronized method is stop!");
//        }
//    }

    public static void main(String[] args) {

        Runnable runnable = ()->{//lumbda创建对象依赖并受限于抽象函数接口
            synchronized (obj){
                System.out.println(Thread.currentThread().getName()+":拿到锁");
                for(;;){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("thread1");
        thread1.start();

        thread1.interrupt();

        Thread thread2 = new Thread(runnable);
        thread2.setName("thread2");
        thread2.start();

    }

}
