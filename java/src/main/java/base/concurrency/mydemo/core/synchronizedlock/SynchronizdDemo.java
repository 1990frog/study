package base.concurrency.mydemo.core.synchronizedlock;

public class SynchronizdDemo {

    private static String value;//静态类变量意义合在？
    private Object obj = new Object();

    static {
        /**
         * 这是个静态代码块，其内嵌一个类同步方法块，它的锁是SynchronizdDemo类的class对象
         */
        synchronized (SynchronizdDemo.class) {
            value = "init";
        }
    }

    public String getValue(){
        return value;
    }

    private synchronized void method1() {
        System.out.println("这是一个同步方法，它的锁是实例对象本身");
    }

    public static synchronized void method2() {
        System.out.println("这是一个同步方法，它的锁是SynchronizdDemo类的class对象");
    }

    public void method3(){
        synchronized (obj){
            System.out.println("这是一个同步代码块，它的锁obj");
        }
    }

    public synchronized void method4(){
        synchronized (SynchronizdDemo.class){
            System.out.println("两把锁：instance，class");
        }
    }

    public static void main(String[] args) {
        SynchronizdDemo synchronizdDemo = new SynchronizdDemo();
        System.out.println(synchronizdDemo.getValue());
    }
}
