package java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 *
 *
 *
 *
 *
 */
public class StreamDemo {

    /**
     * {@link Stream#filter(Predicate)} ()}
     *  切片filter所筛选的数据
     */
    @Test
    public void filter(){
        /**
         * filter筛选数据进行切片返回一个数组
         */
        List<String> words = Arrays.asList("cai1", "cai2", "cai3", "cai4", "cai5");
        List<String> filteredWords = words.stream()
                .filter(word -> word.startsWith("c"))
                .collect(Collectors.toList());
        System.out.println(filteredWords);

        /**
         * filter筛选数据进行切片结果直接遍历（单线程）
         */
        words.stream().filter(word -> word.startsWith("c")).forEach(System.out::println);

        /**
         * filter筛选数据进行切片结果直接遍历（多线程）
         */
        words.stream().parallel().filter(word -> word.startsWith("c")).forEach(System.out::println);
    }

    /**
     * {@link Stream#distinct()} ()}
     *  distinct去重
     */
    @Test
    public void distinct(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 2, 1, 3, 4);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * {@link Stream#distinct()} ()}
     * bean内元素去重
     * distinct（）使用hashCode（）和equals（）方法来区分不同的元素
     * 需要重写方法hashCode（）和equals（）
     */
    @Test
    public void distinctBean(){
        Entity.getEntityList().stream().distinct().forEach(n->System.out.println(n.toString()));
    }

    @Test
    public void limit(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .limit(1)
                .forEach(System.out::println);
    }

    @Test
    public void skip(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void sort(){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 1, 8);
        numbers.stream().sorted().forEach(System.out::println);
    }

    /**
     * 自定义排序
     */
    @Test
    public void sortConditon(){
        List<Integer> numbers = Arrays.asList(2, 3, 11, 4, 5, 6, 7, 1, 8);
        Comparator asc = (a, b) -> b.hashCode() - a.hashCode();
        Comparator desc = (a, b) -> a.hashCode() - b.hashCode();
        Comparator desc_system = Comparator.comparingInt(Object::hashCode);//什么模式
        numbers.stream().sorted(asc).forEach(System.out::println);
        numbers.stream().sorted(desc).forEach(System.out::println);
        numbers.stream().sorted(desc_system).forEach(System.out::println);
    }

    /**
     * {@link Stream#map}
     * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
     *
     */
    @Test
    public void map(){

        @Data
        @AllArgsConstructor
        class Words {
            private String key;
            private String value;
        }

        List<Words> numbers = Arrays.asList(
                new Words("1","哈哈"),
                new Words("2","呵呵"),
                new Words("3","嘿嘿"));
        numbers.stream()
                .map(Words::getKey)
                .forEach(System.out::println);

        List list1 = numbers.stream().map(n->{
            HashMap result = new HashMap();
            result.put("key",n.getKey());
            result.put("value",n.getValue());
            return result;
        }).collect(Collectors.toList());
        System.out.println(list1);

        numbers.stream()
                .map(Words::getValue)
                .map(String::length)
                .forEach(System.out::println);
    }
}
