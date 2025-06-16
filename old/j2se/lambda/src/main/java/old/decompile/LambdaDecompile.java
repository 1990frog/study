package old.decompile;

import java.util.function.Function;

/**
 * <p>
 * 
 * </p>
 *
 * @author cai
 * @since 2022/9/13
 */
public class LambdaDecompile {

    public static void main(String[] args) {
        Function<String,String> function = String::toUpperCase;
        function.apply("hello");
    }

}

//public class LambdaDecompile {
//    public LambdaDecompile() {
//    }
//
//    public static void main(String[] args) {
//        Function<String, String> function = (p) -> {
//            return p.toUpperCase();
//        };
//        function.apply("hello");
//    }
//}
