package learn_runnable;

public class ExceptionDemo implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ExceptionDemo());
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                // 在这里处理未捕获的异常
                System.out.println("Uncaught Exception");
            }
        });
        t.start();
    }
}
