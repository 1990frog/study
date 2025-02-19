package learn_thread.old;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 创建线程
 *
 * @author cai
 */
@Slf4j
public class RunnableDemo {

    public static void main(String[] args) {

    }

    @Test
    public void runnableTest(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread!");
            }
        });
        thread.start();
    }

    @Test
    public void lambdaTest(){
        Thread thread = new Thread(() -> System.out.println("hello thread!"));
        thread.start();
    }

    @Test
    public void threadTest(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("hello thread!");
            }
        };
        thread.start();
    }

    @Test
    public void timerTaskTest(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello thread!");
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task,1000,1000);
    }

    @Test
    public void callableTest(){

    }
}
