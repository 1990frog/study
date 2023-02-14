package collect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 收集器
 * <R, A> R collect(Collector<? super T, A, R> collector)
 * </p>
 *
 * @author cai
 * @since 2023/2/14
 */
public class Test {

    @Data
    @Builder
    @AllArgsConstructor
    static class User {
        private int gender;
        private int age;
        private String name;
    }

    private static final List<User> data = new ArrayList<User>() {{
        add(User.builder().name("lilei").age(12).gender(0).build());
        add(User.builder().name("hanmeimei").age(12).gender(1).build());
        add(User.builder().name("tom").age(13).gender(0).build());
    }};

    /**
     * 工厂方法：toList()
     * 把流中的所有项目收集到一个List
     */
    @org.testng.annotations.Test
    public void toList() {
        List<String> list = data.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 工厂方法：toSet()
     * 把流中的所有项目收集到一个Set，删除重复项
     */
    @org.testng.annotations.Test
    public void toSet() {
        Set<Integer> set = data.stream().map(User::getAge).collect(Collectors.toSet());
        System.out.println(set);
    }

    /**
     * 工厂方法：toMap()
     * 把流中的所有项目收集到一个Map
     */
    @org.testng.annotations.Test
    public void toMap() {
        Map<String, User> map = data.stream().collect(Collectors.toMap(User::getName, n -> n));
        System.out.println(map);
    }

    /**
     * 工厂方法：toCollection()
     * 把流中所有项目收集到给定的供应源创建的集合
     */
    @org.testng.annotations.Test
    public void toCollection() {
        Collection<User> collection = data.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collection);
    }

    @org.testng.annotations.Test
    public void counting() {
        long count1 = data.stream().collect(Collectors.counting());
        long count2 = data.stream().count();
        System.out.println(count1);
        System.out.println(count2);

    }

    @org.testng.annotations.Test
    public void summingInt() {
        int sum1 = data.stream().mapToInt(User::getAge).sum();
        int sum2 = data.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println(sum1);
        System.out.println(sum2);
    }

    @org.testng.annotations.Test
    public void averagingInt(){
        Double avg = data.stream().collect(Collectors.averagingInt(User::getAge));
        System.out.println(avg);
    }

    @org.testng.annotations.Test
    public void summarizingInt(){
        IntSummaryStatistics summary = data.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println(summary);
    }

    @org.testng.annotations.Test
    public void joining(){
        String joining = data.stream().map(User::getName).collect(Collectors.joining(","));
        System.out.println(joining);
    }

    @org.testng.annotations.Test
    public void maxBy(){
        Optional<User> max = data.stream().collect(Collectors.maxBy(Comparator.comparingInt(User::getAge)));
        System.out.println(max);
    }

    @org.testng.annotations.Test
    public void minBy(){
        Optional<User> min = data.stream().collect(Collectors.minBy(Comparator.comparingInt(User::getAge)));
        System.out.println(min);
    }

    @org.testng.annotations.Test
    public void reducing(){
        int total = data.stream().collect(Collectors.reducing(0,User::getAge,Integer::sum));
        System.out.println(total);
    }

    @org.testng.annotations.Test
    public void collectingAndThen(){
        int pass = data.stream().collect(Collectors.collectingAndThen(Collectors.toList(),List::size));
        System.out.println(pass);
    }

    @org.testng.annotations.Test
    public void groupingBy(){
        Map<String,List<User>> grouping = data.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(grouping);
    }

    @org.testng.annotations.Test
    public void partitioningBy(){
        Map<Boolean,List<User>> partitioning = data.stream().collect(Collectors.partitioningBy(n->{return n.gender == 1;}));
        System.out.println(partitioning);
    }

}
