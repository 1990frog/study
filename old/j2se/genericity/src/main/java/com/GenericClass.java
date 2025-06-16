package com;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 泛型类
 * E：Element (在集合中使用，因为集合中存放的是元素)
 * T：Type（Java 类）
 * K：Key（键）
 * V：Value（值）
 * N：Number（数值类型）
 * ?：表示不确定的java类型
 * </p>
 *
 * @author cai
 * @since 2023/2/15
 */
@Data
@AllArgsConstructor
public class GenericClass<E,T,K,V,N> {

    private E e;
    private T t;
    private K k;
    private V v;
    private N n;

    public void print(List<? extends E> list){
        System.out.println(list.contains(e));
    }

    public static void main(String[] args) {
        GenericClass genericClass = new GenericClass(1,2,3,4,"test");
        genericClass.print(Stream.of(1,2,3,4,6).collect(Collectors.toList()));
    }

}
