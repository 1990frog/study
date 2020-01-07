package base.concurrency.moocwukong.core.jmm;


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
 * 要使 volatile 变量提供理想的线程安全，必须同时满足下面两个条件:
 * 1）对变量的写操作不依赖于当前值
 * 2）该变量没有包含在具有其他变量的不变式中
 *
 * 虽然增量操作（x++）看上去类似一个单独操作，实际上它是一个由（读取——修改——写入）操作序列组成的组合操作，必须以原子方式执行，
 * 而 volatile 不能提供必须的原子特性。实现正确的操作需要使 x 的值在操作期间保持不变，而 volatile 变量无法实现这点。
 * （然而，如果将值调整为只从单个线程写入，那么可以忽略第一个条件。）
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
