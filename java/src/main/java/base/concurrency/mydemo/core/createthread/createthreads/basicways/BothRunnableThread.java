package base.concurrency.mydemo.core.createthread.createthreads.basicways;

/**
 *
 * {@Link Thread#start()}
 * {@Link Thread#run()}
 * {@Link RunnableStyle}
 *
 * 描述：
 * 同时使用Runnable和Thread两种实现线程的方式
 */
public class BothRunnableThread {

    public static void main(String[] args) {

        /**
         * Thread本身就继承了Runnable接口
         * new Thread(传递run){覆盖run}
         */
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
