package functioninterface;

import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 * Consumer<T> 接收一个泛型参数，返回void类型
 * </p>
 *
 * @author cai
 * @since 2022/9/4
 */
public class ConsumerStudy {

    public static void test(List<Integer> list, Consumer<Integer> consumer) {
        list.forEach(i->consumer.accept(i));
        list.forEach(consumer::accept);
        list.forEach(consumer);
    }

    public static void main(String[] args) {

    }
}
