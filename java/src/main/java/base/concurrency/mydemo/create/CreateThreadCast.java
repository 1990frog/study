package base.concurrency.mydemo.create;

public class CreateThreadCast implements Runnable {
    @Override
    public void run() {
        while (true)
            System.out.println("1");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CreateThreadCast());
        thread.start();
    }
}
