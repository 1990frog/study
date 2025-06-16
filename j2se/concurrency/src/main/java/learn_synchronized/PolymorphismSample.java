package learn_synchronized;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * 无 synchronized 关键字覆盖同步方法
 */
class NoSynchronizedKeywordOverride extends PolymorphismSample {
    public void synchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " begin");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}

/**
 * 有 synchronized 关键字覆盖同步方法
 */
class WithSynchronizedKeywordOverride extends PolymorphismSample {
    public synchronized void synchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " begin");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}

/**
 * 继承父类方法
 */
class InheritParentClassMethods extends PolymorphismSample {

}

/**
 * 覆盖并使用 super 调用父类方法
 */
class SuperCallsTheParentClassMethod extends PolymorphismSample {
    public void synchronizedMethod() {
        super.synchronizedMethod();
    }
}

public class PolymorphismSample {

    public synchronized void synchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " begin");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }

    /**
     * 覆盖方法未加 synchronized 未继承基类并发关键字
     * 线程1与线程2同时执行
     */
    @Test
    public void testNoSynchronizedKeywordOverride() throws InterruptedException {
        NoSynchronizedKeywordOverride clazz = new NoSynchronizedKeywordOverride();
        Thread t1 = new Thread(clazz::synchronizedMethod);
        Thread t2 = new Thread(clazz::synchronizedMethod);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /**
     * 覆盖方法添加 synchronized 关键字
     * 多态方法为同步方法
     * 线程1，线程2按顺序执行
     *
     */
    @Test
    public void testWithSynchronizedKeywordOverride() throws InterruptedException {
        WithSynchronizedKeywordOverride clazz = new WithSynchronizedKeywordOverride();
        Thread t1 = new Thread(clazz::synchronizedMethod);
        Thread t2 = new Thread(clazz::synchronizedMethod);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /**
     * 未覆盖同步类
     * 子类继承父类全部代码，继承 synchronized 方法
     * 线程1，线程2按顺序执行
     */
    @Test
    public void testInheritParentClassMethods() throws InterruptedException {
        InheritParentClassMethods clazz = new InheritParentClassMethods();
        Thread t1 = new Thread(clazz::synchronizedMethod);
        Thread t2 = new Thread(clazz::synchronizedMethod);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /**
     * 子类覆盖父类并发方法，但是为添加 synchronized 关键字，子类方法并非为同步方法。
     * 但是子类通过 super 调用父类同步方法，仍可实现阻塞，锁为父类的 Class.java
     */
    @Test
    public void testSuperCallsTheParentClassMethods() throws InterruptedException {
        SuperCallsTheParentClassMethod clazz = new SuperCallsTheParentClassMethod();
        Thread t1 = new Thread(clazz::synchronizedMethod);
        Thread t2 = new Thread(clazz::synchronizedMethod);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

