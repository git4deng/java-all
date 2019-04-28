package com.david.jdk8new.stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *Stream流中的常用方法_filter:用于对Stream流中的数据进行过滤
    Stream<T> filter(Predicate<? super T> predicate);
    filter方法的参数Predicate是一个函数式接口,所以可以传递Lambda表达式,对数据进行过滤
    Predicate中的抽象方法:
    boolean test(T t);
 * @author david
 * @create 2019-04-27 20:40
 */
public class S04StreamCommonMethods {
    public static void main(String[] args) {
        System.out.println("-------forEach方法---------");
        forEachMethod();
        System.out.println("-------filter方法---------");
        filterMethod();
        System.out.println("-------map方法---------");
        mapMethod();
        System.out.println("------count方法---------");
        countMethod();
        System.out.println("------limit方法---------");
        limitMethod();
        System.out.println("------skip方法---------");
        skipMethod();
        System.out.println("------concat方法---------");
        concatMethod();
    }

    /**
     *  Stream流中的常用方法_concat:用于把流组合到一起
     如果有两个流，希望合并成为一个流，那么可以使用Stream接口的静态方法concat
     static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
     */
    private static void concatMethod() {
        String[] strs1={"david"};
        Stream<String> s1 = Stream.of(strs1);
        String[] strs2={"tom"};
        Stream<String> s2 = Stream.of(strs2);
        Stream<String> c1 = Stream.concat(s1, s2);
       // c1.forEach(n-> System.out.println(n));
        //不同数据类型的流也能组合
        Integer[] is={12,33};
        Stream<Integer> is1 = Stream.of(is);
        Stream<? extends Serializable> c2 = Stream.concat(is1, c1);
        c2.forEach(n-> System.out.println(n));
    }

    private static void skipMethod() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.stream().skip(3).forEach(n-> System.out.println(n));
    }

    /**
     * Stream流中的常用方法_limit:用于截取流中的元素
     limit方法可以对流进行截取，只取用前n个。方法签名：
     Stream<T> limit(long maxSize);
     参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作
     limit方法是一个延迟方法,只是对流中的元素进行截取,返回的是一个新的流,所以可以继续调用Stream流中的其他方法
     */
    private static void limitMethod() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Stream<Integer> stream = list.stream();
        stream.limit(3).forEach(i-> System.out.println(i));
    }

    /**
     * Stream流中的常用方法_count:用于统计Stream流中元素的个数
     long count();
     count方法是一个终结方法,返回值是一个long类型的整数
     所以不能再继续调用Stream流中的其他方法了
     */
    private static void countMethod() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println("size:"+count);
    }

    /**
     * Stream流中的常用方法_map:用于类型转换
        如果需要将流中的元素映射到另一个流中，可以使用map方法.
        <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        该接口需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
        Function中的抽象方法:
        R apply(T t);
     */
    private static void mapMethod() {
        //获取一个String类型的Stream流
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        Stream<Integer> integer = stream.map(s -> Integer.valueOf(s));
        integer.forEach(i-> System.out.println(i));
    }

    private static void filterMethod() {
        //创建一个Stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");
        stream.filter(name->name.startsWith("张")).forEach(name-> System.out.println(name));
        /*
            Stream流属于管道流,只能被消费(使用)一次
            第一个Stream流调用完毕方法,数据就会流转到下一个Stream上
            而这时第一个Stream流已经使用完毕,就会关闭了
            所以第一个Stream流就不能再调用方法了
            IllegalStateException: stream has already been operated upon or closed
         */
        //遍历stream流
        //stream.forEach(name-> System.out.println(name));//IllegalStateException: stream has already been operated upon or closed
    }

    /**
     * Stream流中的常用方法_forEach
     void forEach(Consumer<? super T> action);
     该方法接收一个Consumer接口函数，会将每一个流元素交给该函数进行处理。
     Consumer接口是一个消费型的函数式接口,可以传递Lambda表达式,消费数据

     简单记:
     forEach方法,用来遍历流中的数据
     是一个终结方法,遍历之后就不能继续调用Stream流中的其他方法
     */
    private static void forEachMethod() {
        Stream<String> s1 = Stream.of("a", "b", "c", "d");
//        s1.forEach((s)->{
//            System.out.println(s);
//        });
        //简写方式

        s1.forEach(name-> System.out.println(name));
    }
}
