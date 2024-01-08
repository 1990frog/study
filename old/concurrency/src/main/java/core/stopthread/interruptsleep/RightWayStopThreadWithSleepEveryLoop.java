package core.stopthread.interruptsleep;

/**
 * 描述：
 * 如果在执行过程中，每次循环都会调用sleep或wait等方法，那么不需要每次迭代都检查是否已中断
 * 这是因为在sleep过程中程序会帮我们响应中断
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
//              while (num <= 10000 && !Thread.currentThread().isInterrupt()) {//多余代码
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    /**
                     * 在休眠的过程中，收到interrupt，自然会抛出异常，所以不用判断!Thread.currentThread().isInterrupt()
                     */
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            while (num <= 10000) {
//                if (num % 100 == 0) {
//                    System.out.println(num + "是100的倍数");
//                }
//                num++;
//            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
