package src.main.java.concurrency.moocwukong.threadcoreknowledge.stopthreads;

/**
 * 描述
 * 最佳实践2：
 * 在catch子语句中调用Thread.currentThread().interrupt()来恢复设置中断状态，以便于在后续的执行中，
 * 依然能够检查到刚才发生了中断回到刚才RightWayStopThreadInProd补上中断，让它跳出
 */
public class RightWayStopThreadInProd2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted，程序运行结束");
                break;
            }
            reInterrupt();
        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);//sleep被中断后，清空interrupted状态
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();//在此重新恢复interruptd状态
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
