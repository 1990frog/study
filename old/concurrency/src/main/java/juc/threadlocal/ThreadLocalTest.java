package juc.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest implements Runnable{

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->0);
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        while (threadLocal.get()<10){
            threadLocal.set(threadLocal.get()+1);
//            System.out.println(Thread.currentThread().getId()+":"+threadLocal.get());
            atomicInteger.incrementAndGet();
            System.out.println(atomicInteger.get());
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++)
            executor.submit(new ThreadLocalTest());
        executor.shutdown();//没有shutdown()会阻塞
    }
}
