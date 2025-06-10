package jvm.stack;

public class StackFrameGC {

    /**
     * 代码没有回收掉 bytes 所占用的内存，因为在执行 System.gc() 时，变量还处于作用域之内，虚拟机自然不敢回收掉 bytes
     * 
     */
    public void test1() {
        byte[] bytes = new byte[1024 * 1024 * 100]; // 100MB
        System.gc();
    }

    /**
     * 代码已经离开了 bytes 的作用域，但在此之后，在没有发生过任何对局部变量表的读写操作，bytes 原本所占用的变量槽还没有被i其它变量所服用，所以作为 GC Roots 一部分的局部变量表仍然保持着对它的关联
     */
    public void test2() {
        {
            byte[] bytes = new byte[1024 * 1024 * 100]; // 100MB
        }
        System.gc();
    }

    public void test3() {
        {
            byte[] bytes = new byte[1024 * 1024 * 100]; // 100MB
        }
        int a = 0;
        System.gc();
    }

    public static void main(String[] args) {
        StackFrameGC stackFrameGC = new StackFrameGC();
        // stackFrameGC.test1();
        stackFrameGC.test2();
        // stackFrameGC.test3();
    }
}
