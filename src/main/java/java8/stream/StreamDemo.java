package java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
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
    public void sorted(){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 1, 8);
        numbers.stream().sorted().forEach(System.out::println);
    }

    /**
     * 自定义排序
     */
    @Test
    public void sortedConditon(){
        List<Integer> numbers = Arrays.asList(2, 3, 11, 4, 5, 6, 7, 1, 8);
        Comparator asc = (a, b) -> b.hashCode() - a.hashCode();
        Comparator desc = (a, b) -> a.hashCode() - b.hashCode();
        Comparator desc_system = Comparator.comparingInt(Object::hashCode);//单条lumbda简写
        numbers.stream().sorted(asc).forEach(System.out::println);
        numbers.stream().sorted(desc).forEach(System.out::println);
        numbers.stream().sorted(desc_system).forEach(System.out::println);
    }

    /**
     * {@link Stream#map}
     * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
     *
     * Returns a stream consisting of the results of applying the given
     * function to the elements of this stream.
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
                .map(Words::getKey)//返回一个流
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

    @Test
    public void mapToInt(){
        @Data
        @AllArgsConstructor
        class Words {
            private String key;
            private String value;
        }

        List<Words> numbers = Arrays.asList(
                new Words("1","哈"),
                new Words("2","呵呵"),
                new Words("3","嘿嘿嘿"));
        numbers.stream()
                .map(Words::getValue)
                .mapToInt(String::length)
                .forEach(System.out::println);

        OptionalInt optionalInt = numbers.stream()
                .map(Words::getValue)
                .mapToInt(String::length)
                .max();
        System.out.println(optionalInt.getAsInt());
    }

    @Test
    public void mapToLong(){
        @Data
        @AllArgsConstructor
        class Words {
            private String key;
            private String value;
        }

        List<Words> numbers = Arrays.asList(
                new Words("1","哈"),
                new Words("2","呵呵"),
                new Words("3","嘿嘿嘿"));
        numbers.stream()
                .map(Words::getValue)
                .mapToLong(String::length)
                .forEach(System.out::println);

        OptionalLong optionalInt = numbers.stream()
                .map(Words::getValue)
                .mapToLong(String::length)
                .max();
        System.out.println(optionalInt.getAsLong());
    }

    @Test
    public void mapToDouble(){
        @Data
        @AllArgsConstructor
        class Words {
            private String key;
            private String value;
        }

        List<Words> numbers = Arrays.asList(
                new Words("1","哈"),
                new Words("2","呵呵"),
                new Words("3","嘿嘿嘿"));
        numbers.stream()
                .map(Words::getValue)
                .mapToDouble(String::length)
                .forEach(System.out::println);

        OptionalDouble optionalInt = numbers.stream()
                .map(Words::getValue)
                .mapToDouble(String::length)
                .max();
        System.out.println(optionalInt.getAsDouble());
    }

    /**
     * {@link Stream#flatMap}
     *  map的输出对应一个元素，必然是一个元素（null也是要返回）
     *  flatmap是0或者多个元素（为null的时候其实就是0个元素）
     *  flatmap的意义在于，一般的java方法都是返回一个结果，但是对于结果数量不确定的时候，用map这种java方法的方式，是不太灵活的，所以引入了flatmap。
     *  对于Optional的map和flatmap：
     *  map是把结果自动封装成一个Optional，但是flatmap需要你自己去封装。
     */
    @Test
    public void flatMap(){

        List<String> words = Arrays.asList("Hello", "World");

        words.stream()
                //return Stream<List<String[]>> map只返回一个结果
                .map(s -> s.split(""))
                //以数组为元素去重
                .distinct()
                //合成包含两个字符串的数组
                .collect(Collectors.toList())
                //PrintStream=System.out
                .forEach(System.out::println);

        words.stream()
                .map(s -> s.split(""))
                //每个字符生成一个流
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<List> list = Arrays.asList(
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(1,2,3,4,8));
        list.stream()
                .flatMap(Collection::stream)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * {@link Stream#flatMapToInt}
     */
    @Test
    public void flatMapToInt(){
        Arrays.asList(
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(1,2,3,4,8)).stream()
                .flatMap(Collection::stream)
                .distinct()
                .forEach(System.out::println);

        /**
         * IntStream mapToInt(ToIntFunction<? super T> mapper);
         */
        int[][] ints = {{1,2,3},{3,4,5,6}};
        Arrays.asList(ints).stream()
                .flatMapToInt(n->Arrays.stream(n))
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * {@link Stream#flatMapToDouble}
     */
    @Test
    public void flatMapToDouble(){

        double[][] data = {{1.5,2.4},{3.2,4.4},{5.2,6.8}};
        Arrays.stream(data)
                .flatMapToDouble(n->Arrays.stream(n))
                .distinct()
                .forEach(System.out::println);

        Arrays.stream(data)
                .flatMapToDouble(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

    }

    /**
     * {@link Stream#flatMapToLong}
     */
    @Test
    public void flatMapToLong(){

        long[][] data = {{1,2},{3,4},{5,6}};
        Arrays.stream(data)
                .flatMapToLong(n->Arrays.stream(n))
                .distinct()
                .forEach(System.out::println);

        Arrays.stream(data)
                .flatMapToLong(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void peek(){
        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .limit(3)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));

        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .skip(6)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));
    }

    @Test
    public void foreach(){
        Stream.of(1,2,3,4,5).forEach(System.out::println);
    }

    @Test
    public void forEachOrdered(){
        //主要的区别在并行流的处理上
        //输出的顺序不一定（效率更高）
        Stream.of(1,2,3,4,5).forEach(n->System.out.print(n+" "));
        System.out.println();
        Stream.of(1,2,3,4,5).parallel().forEach(n->System.out.print(n+" "));
        System.out.println();
        //输出的顺序与元素的顺序严格一致
        Stream.of(7,1,2,3,4,5).forEachOrdered(n->System.out.print(n+" "));
        System.out.println();
        Stream.of(7,1,2,3,4,5).parallel().forEachOrdered(n->System.out.print(n+" "));
    }

    @Test
    public void toArray(){
        Arrays.asList(Stream.of(1, 2, 3, 4, 5).toArray()).forEach(System.out::println);
    }

}
