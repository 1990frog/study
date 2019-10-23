package src.main.java.concurrency.moocwukong.threadcoreknowledge.stopthreads.interruptwait;

public class StopWait implements Runnable{

    Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj){
            try {
                obj.wait();
                System.out.println("wait之后的操作！");
            } catch (InterruptedException e) {
                System.out.println("Interrupt触发了！");
                e.printStackTrace();
            }
            System.out.println("结束阻塞了！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopWait());
        thread.start();
        thread.interrupt();
        thread.join();
        System.out.println("the main thread is stop!");
    }

}
