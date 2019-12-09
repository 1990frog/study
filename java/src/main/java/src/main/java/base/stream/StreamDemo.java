package src.main.java.base.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @See Stream
 * 01.filter {@link #filter()}
 * 02.distinct {@link #distinct()}
 * 03.distinctBean {@link #distinctBean()}
 * 04.limit {@link #limit()}
 * 05.skip {@link #skip()}
 * 06.sorted {@link #sorted()}
 * 07.sortedConditon {@link #sortedConditon()}
 * 08.bobo.playdatastructure.map {@link #map()}
 * 09.mapToInt {@link #mapToInt()}
 * 10.mapToLong {@link #mapToLong()}
 * 11.mapToDouble {@link #mapToDouble()}
 * 12.flatMap {@link #flatMap()}
 * 13.flatMapToInt {@link #flatMapToInt()}
 * 14.flatMapToDouble {@link #flatMapToDouble()}
 * 15.flatMapToLong {@link #flatMapToLong()}
 * 16.peek {@link #peek()}
 * 17.foreach {@link #foreach()}
 * 18.forEachOrdered {@link #forEachOrdered()}
 * 19.toArray {@link #toArray()}
 * 20.reduce {@link #reduce()}
 * 21.collect {@link #collect()}
 * 22.min {@link #min()}
 * 23.max {@link #max()}
 * 24.count {@link #count()}
 * 25.anyMatch {@link #anyMatch()}
 * 26.allMatch {@link #allMatch()}
 * 27.noneMatch {@link #noneMatch()}
 * 28.findFirst {@link #findFirst()}
 * 29.findAny {@link #findAny()}
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
        Entity.getEntityList().stream().distinct().forEach(System.out::println);
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

        Stream.of(2, 3, 4, 5, 6, 7, 1, 8).sorted().forEach(System.out::println);
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
     * <R> Stream<R> bobo.playdatastructure.map(Function<? super T, ? extends R> mapper);
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

    /**
     * {@link Stream#peek}
     */
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

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList())
                .forEach(System.out::println);
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

    /**
     * Object[] toArray();
     * <A> A[] toArray(IntFunction<A[]> generator);
     */
    @Test
    public void toArray(){
        Arrays.asList(Stream.of(1, 2, 3, 4, 5).toArray()).forEach(System.out::println);
    }

    /**
     *  {@link Stream#reduce}
     *
     *  T reduce(T identity, BinaryOperator<T> accumulator);
     *
     *  Optional<T> reduce(BinaryOperator<T> accumulator);
     *
     *  <U> U reduce(U identity,
     *                  BiFunction<U, ? super T, U> accumulator,
     *                  BinaryOperator<U> combiner);
     */
    @Test
    public void reduce(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum1);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        /**
         * 无初始值
         * reduce 还有一个重载的变体，它不接受初始值，但是会返回一个 Optional 对象(考虑到流中没有任何元素的情况)：
         */
        Optional<Integer> sum3 = numbers.stream().reduce(Integer::sum);
        System.out.println(sum3);

        int product1 = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product1);

        Optional product2 = numbers.stream().reduce((a, b) -> a * b);
        System.out.println(product2);

        // 最大值
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max);

        // 最小值
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min);

    }

    /**
     *  <R> R collect(Supplier<R> supplier,
     *                   BiConsumer<R, ? super T> accumulator,
     *                   BiConsumer<R, R> combiner);
     *
     *  <R, A> R collect(Collector<? super T, A, R> collector);
     */
    @Test
    public void collect(){
        Arrays.stream("hello,java8".split(""))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        /**
         * <R> R collect(Supplier<R> supplier,
         *                 BiConsumer<R, ? super T> accumulator,
         *                 BiConsumer<R, R> combiner);
         *
         * HashMap paramMap = paramList.parallelStream().collect(//list转map
         *                 HashMap::new, (m, v) -> m.put(v.get("CODE"), v.get("VALUE")), HashMap::putAll);
         */

    }

    @Test
    public void min(){
        Optional<Integer> min = Stream.of(1,2,3,4,5,6,7,8,9).min(Comparator.comparingInt(a -> a));
        System.out.println(min.get());
    }

    @Test
    public void max(){
        Optional<Integer> max = Stream.of(1,2,3,4,5,6,7,8,9).max(Comparator.comparingInt(a -> a));
        System.out.println(max.get());
    }

    @Test
    public void count(){
        long count = Stream.of(1,2,3,4,5,6,7,8,9).count();
        System.out.println(count);
    }

    @Test
    public void anyMatch(){
        boolean flag1 = Stream.of(1,2,3,4,5,6,7,8,9).anyMatch(n->n>4);
        System.out.println(flag1);

        boolean flag2 = Stream.of(1,2,3,4,5,6,7,8,9).anyMatch(n->n>14);
        System.out.println(flag2);
    }

    @Test
    public void allMatch(){
        boolean flag1 = Stream.of(1,2,3,4,5,6,7,8,9).allMatch(n->n>0);
        System.out.println(flag1);

        boolean flag2 = Stream.of(1,2,3,4,5,6,7,8,9).allMatch(n->n>2);
        System.out.println(flag2);
    }

    @Test
    public void noneMatch(){
        boolean flag1 = Stream.of(1,2,3,4,5,6,7,8,9).noneMatch(n->n>0);
        System.out.println(flag1);

        boolean flag2 = Stream.of(1,2,3,4,5,6,7,8,9).noneMatch(n->n>12);
        System.out.println(flag2);
    }

    @Test
    public void findFirst(){
        Optional<Integer> first = Stream.of(1,2,3,4,5,6,7,8,9).findFirst();
        System.out.println(first.get());
    }

    /**
     * findAny和findFirst返回的，都是第一个对象；
     * 而在并行的流中，findAny返回的是最快处理完的那个线程的数据
     */
    @Test
    public void findAny(){
        Optional<Integer> first = Stream.of(1,2,3,4,5,6,7,8,9).findAny();
        System.out.println(first.get());
    }



}
