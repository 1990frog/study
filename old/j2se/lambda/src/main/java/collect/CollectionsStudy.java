package collect;

import org.testng.annotations.Test;
import util.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 收集器
 *
 * <p>
 * <R> R collect(Supplier<R> var1, BiConsumer<R, ? super T> var2, BiConsumer<R, R> var3);
 * <R, A> R collect(Collector<? super T, A, R> var1);
 * </p>
 *
 * @author cai
 * @since 2023/2/14
 */
public class CollectionsStudy {

    private static final List<User> data = User.getData();

    /**
     * 工厂方法：toList()
     * 把流中的所有项目收集到一个List
     *
     */
    @Test
    public void toList() {
        List<String> list = data.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 工厂方法：toSet()
     * 把流中的所有项目收集到一个Set，删除重复项
     */
    @Test
    public void toSet() {
        Set<Integer> set = data.stream().map(User::getAge).collect(Collectors.toSet());
        System.out.println(set);
    }

    /**
     * 工厂方法：toMap()
     * 把流中的所有项目收集到一个Map
     */
    @Test
    public void toMap() {
        Map<String, User> map = data.stream().collect(Collectors.toMap(User::getName, n -> n));
        System.out.println(map);
    }

    /**
     * 工厂方法：toCollection()
     * 把流中所有项目收集到给定的供应源创建的集合
     */
    @Test
    public void toCollection() {
        Collection<User> collection = data.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collection);
    }

    @Test
    public void counting() {
        long count1 = data.stream().collect(Collectors.counting());
        long count2 = data.stream().count();
        System.out.println(count1);
        System.out.println(count2);

    }

    @Test
    public void summingInt() {
        int sum1 = data.stream().mapToInt(User::getAge).sum();
        int sum2 = data.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println(sum1);
        System.out.println(sum2);
    }

    @Test
    public void averagingInt() {
        Double avg = data.stream().collect(Collectors.averagingInt(User::getAge));
        System.out.println(avg);
    }

    @Test
    public void summarizingInt() {
        IntSummaryStatistics summary = data.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println(summary);
    }

    @Test
    public void joining() {
        String joining = data.stream().map(User::getName).collect(Collectors.joining(","));
        System.out.println(joining);
    }

    @Test
    public void maxBy() {
        Optional<User> max = data.stream().collect(Collectors.maxBy(Comparator.comparingInt(User::getAge)));
        System.out.println(max);
    }

    @Test
    public void minBy() {
        Optional<User> min = data.stream().collect(Collectors.minBy(Comparator.comparingInt(User::getAge)));
        System.out.println(min);
    }

    @Test
    public void reducing() {
        int total = data.stream().collect(Collectors.reducing(0, User::getAge, Integer::sum));
        System.out.println(total);
    }

    @Test
    public void collectingAndThen() {
        int pass = data.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println(pass);
    }

    @Test
    public void groupingBy() {
        Map<String, List<User>> grouping = data.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(grouping);
    }

    @Test
    public void partitioningBy() {
        Map<Boolean, List<User>> partitioning = data.stream().collect(Collectors.partitioningBy(n -> {
            return n.getGender() == 1;
        }));
        System.out.println(partitioning);
    }

}
