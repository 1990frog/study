package src.main.java.base.concurrency.moocwukong.background;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadsError1 implements Runnable {

    static MultiThreadsError1 instance = new MultiThreadsError1();

    int index = 0;
    final boolean[] marked = new boolean[10000000];
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面上结果是："+instance.index);
        System.out.println("真正运行的次数："+realIndex.get());
        System.out.println("错误次数："+wrongCount.get());
        /**
         * 加起来数据对不上
         */
    }

    @Override
    public void run(){
        run1();
//        run2();
//        run3();
//        run4();
    }

    public void run1() {
        /**
         * 只要最后一次9999没有冲突就会达到10000，得到正确结果，但在这过程中有很多重复执行的情况
         */
        while (index<10000){
            index++;
        }
    }


    public void run2() {
        /**
         * 执行超过10000次
         */
        for (int i=0;i<10000;i++) {
            index++;
            realIndex.incrementAndGet();
            /**
             * 运行结果：
             * 表面上结果是：19938
             * 真正运行的次数：20000
             * 错误次数：61
             */
            if(marked[index]){
                wrongCount.incrementAndGet();
                System.out.println("发生了错误"+index);
            }
            marked[index]=true;
        }

    }

    public void run3() {

        /**
         * 执行超过10000次
         */
        for (int i=0;i<10000;i++){
            index++;
            realIndex.incrementAndGet();

            /**
             * 运行结果：
             * 表面上结果是：20000
             * 真正运行的次数：20000
             * 错误次数：670
             *
             * 冲突发生在：
             * 线程一拿到锁，执行synchronized内代码，假设index此时是0，它们发生冲突了，
             * 此时对于两个线程而言index对应都是1，于是第一个线程进来之后，它把marked[1]=true;
             * 第二个线程想要进来，假设当第二个线程运行到if(marked[index])时，cpu把线程一切回来，
             * 让线程一执行，线程一又会执行index++，于是index由1编程2。如果index变成2的情况下，
             * 线程又且回到拿到锁的线程二，线程二就会看到if(marked[index])，index变成2，这和刚才
             * 它们冲突的地点是不一样的，它们冲突的地点是两个index都变成1，于是marked数组的第一位
             * 被写成了true，可是第二个数组进来检查的时候，它其实想检查的是1，可是没想到自己还没开始检查，
             * index就被下一个执行的线程篡改了，所以index是很不准确的，它会大于我们实际想检查的值
             *
             */
            synchronized (instance){
                if(marked[index]){
                    wrongCount.incrementAndGet();
                    System.out.println("发生了错误"+index);
                }
                marked[index]=true;
            }

        }
    }

    public void run4() {
        for (int i=0;i<10000;i++) {
            synchronized (instance){
                index++;
                realIndex.incrementAndGet();
                if (marked[index]) {
                    wrongCount.incrementAndGet();
                    System.out.println("发生了错误" + index);
                }
                marked[index] = true;
            }
        }
    }
}
