package learn_thread.old;

public class DaemonDemo2 {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        try {
            Thread daemon = new Thread(thread::interrupt);
            daemon.setDaemon(true);
            daemon.start();
            daemon.join();
            System.out.println(thread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
        } finally {

        }
    }

}
