package src.main.java.base.concurrency.moocwukong.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 描述：
 * 修改线程名字
 */
public class ThreadSetName {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.setName("11");//线程两个名字，另外一个natie层的名字在线程启动之后无法修改
        System.out.println(thread.getName());
    }
}
