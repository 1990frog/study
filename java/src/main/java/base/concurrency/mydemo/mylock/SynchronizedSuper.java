package base.concurrency.mydemo.mylock;

public class SynchronizedSuper {

    public class A{
        public synchronized void method1(){
            System.out.println("this is method1");
        }
    }

    public class B extends A{
        public synchronized void method1(){
            System.out.println("this is method2");
            super.method1();
        }
    }

    public void test(){
        B b = new B();
        b.method1();
    }


    public static void main(String[] args) {
        SynchronizedSuper synchronizedSuper = new SynchronizedSuper();
        synchronizedSuper.test();
    }
}
