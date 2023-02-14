package old;

/**
 * Lambda 与 内部类
 * <p>
 * 函数式接口(Functional Interface)：
 * 就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 */
public class LamOrInner {

    /**
     * The R 1.
     */
    Runnable r1 = () -> System.out.println("Hello World 1");

    /**
     * The R 2.
     */
    Runnable r2 = new Runnable() {//Functional Interface
        @Override
        public void run() {
            System.out.println("Hello World 2");
        }
    };

    /**
     * Process.
     *
     * @param r the r
     */
    public static void process(Runnable r){
        r.run();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LamOrInner li = new LamOrInner();
        process(li.r1);//函数式接口(Functional Interface)
        process(li.r2);
        process(()->System.out.println("Hello World 3"));//函数式接口(Functional Interface)
    }

}
