package javase.base.exception;

public class InterruptedExceptionDemo implements Runnable {

    @Override
    public void run() {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test() throws InterruptedException {
        while (true){
            if(Thread.currentThread().isInterrupted()){
                throw new InterruptedException();
            }
        }
    }

    public static void test2() throws InterruptedException {
        Thread.currentThread().isAlive();

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new InterruptedExceptionDemo());
        t.start();
        t.interrupt();
        t.join();
        System.out.println("end!");
    }


}
