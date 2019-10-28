package src.main.java.base.concurrency.moocwukong.threadcoreknowledge.stopthreads.extend;

public class ExceptionInWhile {

    /**
     * test1：
     * while中try/catch抛出异常，当次循环不会向下执行，但是后续循环会执行
     * ==>try/catch只会中断当次循环？
     */
    public static void test1(){
        int i=0;
        while (i<10){
            try {
                System.out.println(10/i);
            }catch (ArithmeticException e){
                System.out.println("i为"+i+"时，抛出错误！");
                e.printStackTrace();
            }
        }
        i++;
    }

    public static void test2(){
        int i=0;
        try {
            while (i<10){
                System.out.println(10/i);
            }
            i++;
        }catch (ArithmeticException e){
            System.out.println("i为"+i+"时，抛出错误！");
            e.printStackTrace();
        }
    }

    /**
     * test3：
     * 改进
     */
    public static void test3(){
        int i=0;
        while (i<10){
            try {
                System.out.println(10/i++);
            }catch (ArithmeticException e){
                System.out.println("i为"+(i-1)+"时，抛出错误！");
                e.printStackTrace();
            }
        }
    }

    /**
     * 总结：代码结构体优先级
     * loop不会因为一次执行，抛出异常，而导致中断整个循环
     */
    public static void main(String[] args) {
//        test1();
        test2();
//        test3();
    }
}
