package lambda;

/**
 *  Lambda 与 内部类
 *
 */
public class LamOrInner {

    Runnable r1 = () -> System.out.println("Hello World 1");

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello World 2");
        }
    };

    public static void process(Runnable r){
        r.run();
    }

    public static void main(String[] args) {
        LamOrInner li = new LamOrInner();
        process(li.r1);//函数式接口(Functional Interface)
        process(li.r2);
        process(()->System.out.println("Hello World 3"));//函数式接口(Functional Interface)
    }

}
