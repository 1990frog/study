package learn_exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    private static final Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                String val = exchanger.exchange("t1");
                System.out.println("t1 get val: "+ val);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1");

        Thread t2 = new Thread(()->{
            try {
                String val = exchanger.exchange("t2");
                System.out.println("t2 get val: "+ val);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
