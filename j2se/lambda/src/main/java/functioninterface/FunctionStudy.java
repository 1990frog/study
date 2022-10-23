package functioninterface;

import java.util.function.Function;

/**
 * <p>
 * Function<T,R> 接口定义了一个叫做 apply 的方法，它接受一个泛型 T 对象，并返回一个泛型 R 的对象。
 * 如果你需要定义一个 Lambda，将输入对象的信息映射到输出，就可以使用这个接口。
 * </p>
 *
 * @author cai
 * @since 2022/9/4
 */
public class FunctionStudy {
    public static void main(String[] args) {
        Function<Integer,String> func = (Integer t) -> t+"";
//        Function<Integer,String> func = String::valueOf;
//        Function<Integer,String> func = Object::toString;
        System.out.println(func.apply(123));
    }
}
