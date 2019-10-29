package src.main.java.base.concurrency.moocwukong.threadcoreknowledge.stopthreads.volatiledemo;

/**
 * 描述：
 * 演示用volatile的局限：part1 看似可行,实则不行
 */
public class WrongWayVolatile implements Runnable {

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            /**
             * 如果使用Thread.currentThread().isInterrupted()也不会即刻中断啊？
             * 如果业务需求是执行完当前业务，那volatile貌似也可以的啊？
             */
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数。");
                }
                num++;
                Thread.sleep(1);//阻塞时间短，不会发生在阻塞期间更改中断状态
//                Thread.sleep(100000);//阻塞时间长，此时发生中断状态更改，volatile无效
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile r = new WrongWayVolatile();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(5000);
        r.canceled = true;
        System.out.println("发起中断");
    }
}

