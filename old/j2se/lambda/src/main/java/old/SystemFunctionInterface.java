package old;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 系统提供的几种函数式接口
 * @see #supplier
 */
public class SystemFunctionInterface {

    /**
     * Supplier(null->T)
     * 供应商，提供返回值
     */
    public Supplier supplier(){
        // 函数初始化
        Supplier fun = ()->"supplier";
        // 函数调用
        System.out.println(fun.get());
        // 返回函数类型
        return fun;
    }

    /**
     * Consumer(T->null)
     * 消费者接口，接收一个参数<T>
     */
    public Consumer consumer(){
        Consumer consumer = n->System.out.println(n);
        consumer.accept("consumer");
        return consumer;
    }

    /**
     * Runner(null->null)
     * 异步，无参无返回值
     */
    public Runnable runnable(){
        Runnable runnable = ()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        runnable.run();
        return runnable;

    }

    /**
     * Function(<T, R>->T)
     * 函数，有参有返回值，提供了两个泛型
     */
    public Function function(){
        Function<Integer,String> function = a->{
            return String.valueOf(a);
        };
        System.out.println(function.apply(19));
        return function;
    }

    /**
     * Predicate(<T>->boolean)
     * 断言，返回boolean
     * 可以使用or，and将多个Predicate连接在一起形成一个复杂的Predicate
     */
    public Predicate predicate(){
        int b =100;
        Predicate<Integer> predicate1 = a->{
            return a>100;
        };
        Predicate<Integer> predicate2 = a->{
            return a>200;
        };
        Predicate<Integer> predicate3 = a->{
            return a>300;
        };

        Predicate predicate4 = predicate1.or(predicate2)
                .and(predicate3);

        System.out.println(predicate4.test(400));

        return predicate4;

    }


    @Test
    public void test(){
        Supplier supplier = supplier();
        System.out.println(supplier.get());
        List list = new ArrayList<>();
        Consumer<Integer> con1 = (Integer a) -> System.out.println(a);
        Consumer<Integer> con2 = (Integer a) ->list.add(a);
    }
}
