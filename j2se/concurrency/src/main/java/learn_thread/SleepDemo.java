package learn_thread;

import org.testng.annotations.Test;

public class SleepDemo {

    @Test
    public void sleepTest(){
        System.out.println("start !");
        try {
            Thread.sleep(2000L);
            System.out.println("this is sleep test!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end !");
    }
}
