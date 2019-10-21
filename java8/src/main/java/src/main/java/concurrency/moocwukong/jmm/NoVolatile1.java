package src.main.java.concurrency.moocwukong.jmm;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：
 * 不适用于volatile的场景
 *
 * volatile只保证可见性，并不具有原子性（一般的赋值是可以保证原子性的，a++例外）
 *
 * 不要将volatile用在getAndOperate场合（这种场合不原子，需要再加锁），仅仅set或者get的场景是适合volatile的。
 * 例如你让一个volatile的integer自增（i++），其实要分成3步：
 * 1）读取volatile变量值到local；
 * 2）增加变量的值；
 * 3）把local的值写回，让其它的线程可见。
 *
 * 这3步的jvm指令为：
 * mov    0xc(%r10),%r8d ; Load
 * inc    %r8d           ; Increment
 * mov    %r8d,0xc(%r10) ; Store
 * lock addl $0x0,(%rsp) ; StoreLoad Barrier
 * 注意最后一步是内存屏障。
 *
 */
public class NoVolatile1 implements Runnable {

    volatile int a;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r =  new NoVolatile1();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((NoVolatile1) r).a);
        System.out.println(((NoVolatile1) r).realA.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            a++;
            realA.incrementAndGet();
        }

        /**
         * 原子操作
         */
//        for (int i = 0; i < 10000; i++) {
//            synchronized (this){
//                a++;
//            }
//            realA.incrementAndGet();
//        }
    }

}
