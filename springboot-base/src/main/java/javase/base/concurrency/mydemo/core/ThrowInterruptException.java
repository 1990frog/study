package javase.base.concurrency.mydemo.core;

public class ThrowInterruptException {

    public void interrupt1() throws InterruptedException{
        while (true);
    }

    public void interrupt2() throws InterruptedException{
        while (true){
            if(Thread.currentThread().isInterrupted()){
                throw new InterruptedException();
            }
        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {
                new ThrowInterruptException().interrupt1();
            } catch (InterruptedException e) {
                System.out.println("thread1 is stop!");
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                new ThrowInterruptException().interrupt2();
            } catch (InterruptedException e) {
                System.out.println("thread2 is stop!");
                e.printStackTrace();
            }
        });

        thread1.start();
        thread1.interrupt();

        thread2.start();
        thread2.interrupt();
    }
}
