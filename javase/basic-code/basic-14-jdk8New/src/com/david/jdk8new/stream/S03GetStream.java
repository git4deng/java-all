package com.david.jdk8new.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream<T>是Java 8新加入的最常用的流接口。（这并不是一个函数式接口。）
    获取一个流非常简单，有以下几种常用的方式：
    - 所有的Collection集合都可以通过stream默认方法获取流；
    default Stream<E> stream​()
    - Stream接口的静态方法of可以获取数组对应的流。
    static <T> Stream<T> of​(T... values)
    参数是一个可变参数,那么我们就可以传递一个数组
 * @author david
 * @create 2019-04-27 20:27
 */
public class S03GetStream {
    public static void main(String[] args) {
        System.out.println("-----------把集合转换成流------------");
        List<String> list=new ArrayList<>();
        Stream<String> s1 = list.stream();

        Set<String> set=new HashSet<>();
        Stream<String> s2 = set.stream();
        //hashMaP间接转换成流
        Map<String,String> map=new HashMap<>();
        //key是一个单列的集合
        Set<String> set1 = map.keySet();
        Stream<String> s3 = set1.stream();

        Collection<String> values = map.values();
        Stream<String> s4 = values.stream();
        //获取键值对(键与值的映射关系 entrySet)
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> s5 = entries.stream();

        //数组转换stream流
        Stream<Integer> s6 = Stream.of(1, 2, 3, 4, 5);
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream7 = Stream.of(arr);
        String[] arr2 = {"a","bb","ccc"};
        Stream<String> stream8 = Stream.of(arr2);

    }
}
