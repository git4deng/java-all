package com.david.jdk8new.commonFunctionalInterface;

import java.util.function.Predicate;

/**
 * java.util.function.Predicate<T>接口
 作用:对某种数据类型的数据进行判断,结果返回一个boolean值

 Predicate接口中包含一个抽象方法：
 boolean test(T t):用来对指定数据类型数据进行判断的方法
 结果:
 符合条件,返回true
 不符合条件,返回false
 * @author david
 * @create 2019-04-26 23:05
 */
public class F06Predicate {
    public static void main(String[] args) {

        boolean b = testString("david", (s) -> {
            return s.length() > 5 ? true : false;
        });
        System.out.println("david字符串长度超过5吗？"+(b?"是":"否"));

    }
    public static boolean testString(String str, Predicate<String> p){
        return p.test(str);
    }
}
