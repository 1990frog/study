package old.methodInvoke;

import java.util.List;
import java.util.function.BiPredicate;

/**
 * <p>
 * 
 * </p>
 *
 * @author cai
 * @since 2022/9/8
 */
public class MethodInvokeStudy {

    public static void main(String[] args) {
        BiPredicate<List<String>,String> func1 = (List<String> list,String target) -> list.contains(target);
        BiPredicate<List<String>,String> func2 = List::contains;
    }
}
