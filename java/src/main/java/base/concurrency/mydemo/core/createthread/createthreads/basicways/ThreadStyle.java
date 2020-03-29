package base.concurrency.mydemo.core.createthread.createthreads.basicways;

/**
 * class Thread(){
 *     ...
 *     @Override
 *     public void run() {
 *         if (target != null) {
 *             target.run();
 *         }
 *     }
 *     ...
 * }
 *
 * 描述：
 * 用Thread方式实现线程
 */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }

}





