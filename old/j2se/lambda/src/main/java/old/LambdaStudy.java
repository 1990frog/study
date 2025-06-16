package old;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaStudy {

    @Test
    public void test() {
        List<Integer> orders = Arrays.asList(4, 3, 6, 2, 1, 77, 44);
        // 匿名类
        Collections.sort(orders, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        // Lambda 表达式，创建接口实例
//        Collections.sort(orders,(i,j)->Integer.compare(i,j));
//        System.out.println(orders);
//        Collections.sort(orders,comparingInt(String::length));
//        Collections.sort(orders, Integer::compare);
//        System.out.println(orders);
        orders.sort(Integer::compare);
        System.out.println(orders);


    }
}
