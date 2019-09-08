package src.main.java.concurrency.moocwukong.threadcoreknowledge.stopthreads;


/**
 * 描述：
 * 最佳实践：catch了InterruptedExcetion之后的优先选择在方法签名中抛出异常
 * 如果这样做，那么在run()就会强制try/catch
 *
 */
public class RightWayStopThreadInProd1 implements Runnable {

    /**
     * run方法不允许跑出异常
     * 因为run方法是Override，来自顶层方法的覆盖，而顶层方法没有做出任何异常的抛出
     */
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                /**
                 * 在被调用的子函数中，添加异常签名，强迫调用方处理异常
                 *
                 * 异常应由顶层的调用处理
                 */
                throwInMethod();
            } catch (InterruptedException e) {
                //保存日志、停止程序 TODO
                System.out.println("保存日志");
                e.printStackTrace();
//                break;
            }
        }
    }

    /**
     * 添加异常到方法签名
     *
     * 方法签名抛出异常，调用该方法的方法就不被强迫抛出异常
     *
     * @throws InterruptedException
     */
    private void throwInMethod() throws InterruptedException {
            Thread.sleep(2000);

//            try{
//                Thread.sleep(2000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
    }

    /**
     * 在顶层函数中处理异常
     *
     * 异常抛出最好交给顶层的调用处理，因为我们不晓得顶层调用具体的逻辑
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd1());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
