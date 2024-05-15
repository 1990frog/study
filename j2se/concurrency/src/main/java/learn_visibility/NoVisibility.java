package learn_visibility;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReadsThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReadsThread().start();
        number = 42;
        ready = true;
    }
}
