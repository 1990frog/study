package core.createthread;

import org.junit.Test;

public class CreateThread implements Runnable {

    @Override
    public void run() {
        System.out.println("run");
    }

    /**
     * Thread+Runnable
     */
    @Test
    public void threadDemo(){
        new Thread(new CreateThread()).start();
    }

    /**
     * 重写Thread的run方法
     */
    public void ThreadRunDemo(){
        new Thread(){
            @Override
            public void run() {
                System.out.println("thread run");
            }
        }.start();
    }

    public void ThreadRunnable(){
        new Thread(new CreateThread()){
            @Override
            public void run() {
                System.out.println("thread run");
            }
        }.start();
    }


    /**
     * Thread+Lambda
     */
    @Test
    public void lambdaDemo(){
        new Thread(()-> System.out.println("lambda")).start();
    }



    /**
     * 线程池
     */

    /**
     * TimerTask
     */

    /**
     * Callable
     */

}
