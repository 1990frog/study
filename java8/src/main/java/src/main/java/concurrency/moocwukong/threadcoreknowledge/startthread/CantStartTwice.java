package src.main.java.concurrency.moocwukong.threadcoreknowledge.startthread;

/**
 * 描述：
 * 演示不能两次调用start方法，否则会报错
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
