package base.concurrency.moocwukong.core.threadcoreknowledge.stopthreads.interruptjoin;

public class StopJoin{

    public static void main(String[] args) throws InterruptedException {

        Thread mainThread = Thread.currentThread();

        Thread thread1 = new Thread(()->{
            try {
                /**
                 * thread1.join的过程：waiting状态
                 */
                mainThread.join();
//                Thread.sleep(5000);
                System.out.println("主线程运行完毕！");
            } catch (InterruptedException e) {
                System.out.println("thread1被中断");
                e.printStackTrace();
            }
            System.out.println("thread1 try外面接着运行！");
        });

        Thread thread2 = new Thread(()->{
            thread1.interrupt();
        });

        thread1.start();
        thread2.start();
        Thread.sleep(2000);

    }

}
