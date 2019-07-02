package lambda;

public class TwoThread {

    public static void OldThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).start();
    }

    public static void NewThread() {
        new Thread(() -> System.out.println("Hello World!")).start();
    }

    public static void main(String[] args) {
        TwoThread.OldThread();
        TwoThread.NewThread();
    }
}
