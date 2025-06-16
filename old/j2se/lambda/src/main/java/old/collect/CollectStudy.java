package old.collect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.testng.annotations.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/10/15
 */
public class CollectStudy {

    private List<User> list = new ArrayList<>();

    {
        list.add(User.builder().id(1L).name("lilei").age(16).weight(70.50).gender(1).build());
        list.add(User.builder().id(1L).name("hanmeimei").age(20).weight(60.24).gender(2).build());
    }

    @Data
    @Builder
    static class User {
        private String name;
        private Integer age;
        private Double weight;
        private Integer gender;
        private Long id;
    }

    @Test
    public void reduce() {
        System.out.println(list.stream().collect(Collectors.counting()));
        System.out.println(list.stream().count());
        //
        Optional<Integer> maxAge1 = list.stream().map(User::getAge).collect(Collectors.maxBy(Integer::compareTo));
        Optional<Integer> maxAge2 = list.stream().map(User::getAge).max(Integer::compareTo);
        System.out.println(maxAge1.get());
        System.out.println(maxAge2.get());

//        list = new ArrayList<>();
        int sumAge1 = list.stream().collect(Collectors.summingInt(User::getAge));
        BinaryOperator<Integer> bifunc1 = (i, j) -> i + j;
        Optional<Integer> sumAge2 = list.stream().map(User::getAge).reduce(bifunc1);
        System.out.println(sumAge1);
        System.out.println(sumAge2.get());

        double sumWeight = list.stream().collect(Collectors.summingDouble(User::getWeight));
        double avgWeight = list.stream().collect(Collectors.averagingDouble(User::getWeight));
        DoubleSummaryStatistics staistics = list.stream().collect(Collectors.summarizingDouble(User::getWeight));
        System.out.println(sumWeight);
        System.out.println(avgWeight);
        System.out.println(staistics);

        System.out.println(list.stream().map(User::getName).collect(Collectors.joining()));
        System.out.println(list.stream().map(User::getName).collect(Collectors.joining(",")));

        Integer a = list.stream().map(User::getAge).collect(Collectors.reducing(0, bifunc1));
        // 单参数没有初始值，故返回Optional
        Optional<Integer> b = list.stream().map(User::getAge).collect(Collectors.reducing(bifunc1));
        Integer c = list.stream().collect(Collectors.reducing(0, User::getAge, bifunc1));
        // Integer.sum BinaryOperator 类型
        // reduce 把两个值规约为一个值（同类型）
        Integer d = list.stream().collect(Collectors.reducing(0, User::getAge, Integer::sum));

        Optional<Integer> e = list.stream().map(User::getAge).reduce(Integer::sum);

        System.out.println(a);
        System.out.println(b.get());
        System.out.println(c);
        System.out.println(d);

        Optional<User> maxAgeUser = list.stream().collect(Collectors.reducing((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2));
        System.out.println(maxAgeUser);

    }
}
