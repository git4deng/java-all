package com.david.jdk8new.commonFunctionalInterface;

import java.util.function.Supplier;

/**
 * 常用的函数式接口
 java.util.function.Supplier<T>接口仅包含一个无参的方法：T get()。用来获取一个泛型参数指定类型的对象数据。

 Supplier<T>接口被称之为生产型接口,指定接口的泛型是什么类型,那么接口中的get方法就会生产什么类型的数据
 * @author david
 * @create 2019-04-26 22:14
 */
public class F01Supplier {
    public static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        //String str=getString(()->{return "hello world!";});

        String str=getString(()->"hello world");
        System.out.println(str);
    }

}
