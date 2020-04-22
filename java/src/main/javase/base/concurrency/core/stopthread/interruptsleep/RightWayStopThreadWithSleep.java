package javase.base.concurrency.core.stopthread.interruptsleep;

/**
 * 描述：
 * 带有sleep的中断线程的写法
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(2000);//在这阶段中断，此demo为测试中断sleep

//                if (Thread.currentThread().isInterrupted()){// 没得效果
//                    System.out.println("This thread is interrupted!");
//                }
            } catch (InterruptedException e) {
                //中断发生后，interrupted状态被清空！变为false
                System.out.println("this Thread's interrupt status :"+ Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}

/**
 *
 * 中断阻塞线程
 *
 * 运行结果，调用了sleep方法的线程被中断，会抛出异常
 *
 * 当线程正在休眠的过程中（sleep）,如果收到中断信号（interrupt),
 * 于是它便会响应这个中断，其响应中断的方式便是抛出一个异常
 *
 */
