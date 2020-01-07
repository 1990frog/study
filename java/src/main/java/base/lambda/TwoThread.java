package base.lambda;

/**
 * The type Two thread.
 */
public class TwoThread {

    /**
     * Old thread.
     */
    public static void OldThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).start();
    }

    /**
     * New thread.
     */
    public static void NewThread() {
        new Thread(() -> System.out.println("Hello World!")).start();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TwoThread.OldThread();
        TwoThread.NewThread();
    }
}
