package base.concurrency.mydemo.core;

public class ShutDownHook {

    public static void main(String[] args) {
        System.out.println("hello");
        Thread close_jvm = new Thread(()-> System.out.println("close"));
        Runtime.getRuntime().addShutdownHook(close_jvm);
        System.out.println("world");
    }
}
