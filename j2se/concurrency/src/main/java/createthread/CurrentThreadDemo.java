package createthread;

public class CurrentThreadDemo {

    public static void main(String[] args) {
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
        System.out.println(Thread.currentThread().getName());
    }
}
