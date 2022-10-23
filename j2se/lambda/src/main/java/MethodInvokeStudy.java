import org.testng.annotations.Test;

import java.util.function.BiPredicate;

public class MethodInvokeStudy {

    /**
     * 三类方法引用：
     * 1、静态方法
     * 2、任意类型实例方法
     * 3、现有对象的实例方法的引用
     */
    @Test
    public void test1() {
        BiPredicate<String, String> biPredicate = String::contains;
        System.out.println(biPredicate.test("RNM", "NM"));
    }
}
