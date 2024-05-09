package learn_thread;

import org.testng.annotations.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author caijingquan
 * @since 2024/5/7
 */
public class ThreadGroupDemo {

    @Test
    public void properties(){
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getMaxPriority());
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
    }
}
