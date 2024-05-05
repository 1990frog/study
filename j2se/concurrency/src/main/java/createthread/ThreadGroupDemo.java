package createthread;

import org.testng.annotations.Test;

public class ThreadGroupDemo {

    @Test
    public void properties(){
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getMaxPriority());
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
    }
}
