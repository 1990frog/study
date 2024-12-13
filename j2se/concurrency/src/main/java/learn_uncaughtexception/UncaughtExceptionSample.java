package learn_uncaughtexception;

public class UncaughtExceptionSample implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new UncaughtExceptionSample());
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                // 在这里处理未捕获的异常
                System.out.println("Uncaught Exception");
            }
        });
        t.start();
    }
}
