package base.concurrency.moocwukong.core.synchronizedlock;

public class SynchronizedSuperClass12 {
    public synchronized void doSomething(){
        System.out.println("我是父类的方法");
    }
}

class TestClass extends SynchronizedSuperClass12{

    @Override
    public synchronized void doSomething(){
        System.out.println("我是子类的方法");
        super.doSomething();//synchronized父类的锁等同子类？
    }

    public static void main(String[] args) {
        TestClass s = new TestClass();
        s.doSomething();
    }
}
