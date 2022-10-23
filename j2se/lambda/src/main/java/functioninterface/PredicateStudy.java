package functioninterface;

import java.util.function.Predicate;

/**
 * <p>
 * Predicate<T> 接收一个参数，返回Boolean类型
 * </p>
 *
 * @author cai
 * @since 2022/9/4
 */
public class PredicateStudy {

    public static void test(Predicate<Integer> predicate, Integer param) {
        System.out.println(predicate.test(param));
    }

    public static void main(String[] args) {
        Predicate<Integer> func = (Integer param) -> param > Integer.MIN_VALUE;
        System.out.println(func.test(10));
        test(func, 100);
    }
}
