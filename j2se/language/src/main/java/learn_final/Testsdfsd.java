package learn_final;

import org.testng.annotations.Test;

public class Testsdfsd {
    static MyObj obj;

    static class MyObj {
        int a, b, c, d;

        MyObj() {
            a = 1;
            b = 1;
            c = 1;
            d = 1;
        }
    }

    // Thread 1
    public static void init() {
        obj = new MyObj();
    }

    // Thread 2
    public static void f() {
        if (obj == null) return;
        if (obj != null) {
			System.out.println(obj.a + obj.b + obj.c + obj.d);
		}
    }

    @Test(invocationCount = 100000)
    public void test() {
        new Thread(Testsdfsd::init).start();
        new Thread(Testsdfsd::f).start();
    }

}