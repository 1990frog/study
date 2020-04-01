package javase.base.concurrency.mydemo.core.synchronizedlock;

public class SynchronizeOtherMethod11 {

    public synchronized void method1(){
        System.out.println("我是method1");
        method2();
    }

    private synchronized void method2(){
        System.out.println("我是method2");
    }



    public static void main(String[] args) {

        SynchronizeOtherMethod11 synchronizeOtherMethod1 = new SynchronizeOtherMethod11();
        synchronizeOtherMethod1.method1();

    }

}
