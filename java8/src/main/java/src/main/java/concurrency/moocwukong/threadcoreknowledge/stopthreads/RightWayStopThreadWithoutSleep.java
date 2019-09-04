package src.main.java.concurrency.moocwukong.threadcoreknowledge.stopthreads;

/**
 * 描述：
 * run方法内没有sleep或wait方法时，停止线程
 *
 * 疑问：
 * 为何run方法中的循环没办法被中断？
 *
 * 因为调用Thread.interrupt()方法，只是将线程的状态改变为中断，并不会直接中断线程
 * 所以可以在循环中判断中断状态是否改变
 * ?interrupt的中断处理，需要自己手动处理?
 */
public class RightWayStopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }

//        /**
//         * for 也可以实现
//         */
//        for(int i=0;i<Integer.MAX_VALUE/2 && !Thread.currentThread().isInterrupted();i++){
//            if (i % 10000 == 0) {
//                System.out.println(i + "是10000的倍数");
//            }
//        }

        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
