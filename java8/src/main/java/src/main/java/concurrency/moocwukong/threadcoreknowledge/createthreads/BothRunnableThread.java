package src.main.java.concurrency.moocwukong.threadcoreknowledge.createthreads;

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
 * 同时使用Runnable和Thread两种实现线程的方式
 */
public class BothRunnableThread {

    /**
     * 调用一：
     * new Thread(new Runnable())，将Runnable对象传递给Thread，然后在Run方法中，调用传递过来的Runnable的run
     *
     * 方法二：
     * extend Thread
     * 重写run方法
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
