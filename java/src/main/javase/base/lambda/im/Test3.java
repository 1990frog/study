package javase.base.lambda.im;

import java.util.*;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {

    public static void main(String[] args) {
        // list -> stream
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(list);

        // map(Function(T, R)-> R) 接受一个参数，通过运算得到转换后的数据
        // collect()
        List<Double> list2 = list.stream().map(x->Math.pow(x, 2)).collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~");

        // arrays -> stream
        Integer [] nums = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.asList(nums));

        // filter(Predicate(T t)->Boolean) 接受一个参数，验证参数是否符合设置的条件
        // toArray() 从Stream类型抽取数据转换成数组
        Integer [] nums2 = Stream.of(nums).filter(x -> x % 2 == 0).toArray(Integer[]::new);
        System.out.println(Arrays.asList(nums2));

        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~");
        // forEach: 接受一个lambda表达式，在Stream每个元素上执行指定的操作
        list.stream().filter(n->n%2==0).forEach(System.out::println);

        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~");

        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(3);
        numList.add(2);
        numList.add(5);
        numList.add(4);
        numList.add(6);

        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~");
        // reduce
        Optional<Integer> sum = numList.stream().reduce((x, y) -> x + y);
        System.out.println(sum.get());

        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~");
        // limit
        List limitNum = numList.stream().limit(2).collect(Collectors.toList());
        System.out.println(limitNum);

        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~");
        // skip
        List limitNum2 = numList.stream().skip(2).collect(Collectors.toList());
        System.out.println(limitNum2);

        System.out.println("~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~ * ~");
        // sorted().一般在skip/limit或者filter之后进行
        List sortedNum = numList.stream().skip(2).limit(5).sorted().collect(Collectors.toList());
        System.out.println(sortedNum);

        // min/max/distinct
        Integer minNum = numList.stream().min((o1, o2)->{return o1-o2;}).get();
        System.out.println(minNum);
        Integer maxNum = numList.stream().max((o1, o2)->o1-o2).get();
        System.out.println(maxNum);
    }
}
