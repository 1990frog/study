package javase.base.concurrency.core.createthread;

/**
 * 描述：
 * 演示不能两次调用start方法，否则会报错
 *
 * if (threadStatus != 0)
 *  throw new IllegalThreadStateException();
 *
 * 第一次启动threadStatus状态更改，第二次启动就直接抛出异常
 *
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.getState());//STATE：NEW
        thread.start();
        System.out.println(thread.getState());//STATE：RUNNABLE
        thread.start();
    }
}
