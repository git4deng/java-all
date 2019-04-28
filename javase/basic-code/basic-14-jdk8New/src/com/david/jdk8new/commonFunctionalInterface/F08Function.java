package com.david.jdk8new.commonFunctionalInterface;

import java.util.function.Function;

/**
 * java.util.function.Function<T,R>接口用来根据一个类型的数据得到另一个类型的数据，
 前者称为前置条件，后者称为后置条件。
 Function接口中最主要的抽象方法为：R apply(T t)，根据类型T的参数获取类型R的结果。
 使用的场景例如：将String类型转换为Integer类型。
 * @author david
 * @create 2019-04-26 23:40
 */
public class F08Function {
    public static void main(String[] args) {
        String s="1234";//注意转换异常
        Integer n=string2Integer(s,(str)->Integer.valueOf(str));
        System.out.println(n);

        System.out.println("-----------Fuction接口默认方法andThen使用--------------");
        String result = defualtMehodAndThen(s, (str) -> Integer.valueOf(str) + 10, (number) -> String.valueOf(number));
        System.out.println(result);
    }

    /**
     * 定义一个方法
     方法的参数传递一个字符串类型的整数
     方法的参数传递一个Function接口,泛型使用<String,Integer>
     使用Function接口中的方法apply,把字符串类型的整数,转换为Integer类型的整数
     * @param s
     * @param f
     * @return
     */
    public static Integer string2Integer(String s, Function<String,Integer> f){
        return f.apply(s);
    }

    /**
     * Function接口中的默认方法andThen:用来进行组合操作

     需求:
     把String类型的"123",转换为Inteter类型,把转换后的结果加10
     把增加之后的Integer类型的数据,转换为String类型

     分析:
     转换了两次
     第一次是把String类型转换为了Integer类型
     所以我们可以使用Function<String,Integer> fun1
     Integer i = fun1.apply("123")+10;
     第二次是把Integer类型转换为String类型
     所以我们可以使用Function<Integer,String> fun2
     String s = fun2.apply(i);
     我们可以使用andThen方法,把两次转换组合在一起使用
     String s = fun1.andThen(fun2).apply("123");
     fun1先调用apply方法,把字符串转换为Integer
     fun2再调用apply方法,把Integer转换为字符串
     * @param s
     * @param f1
     * @param f2
     * @return
     */
    public static String defualtMehodAndThen(String s,Function<String,Integer> f1,Function<Integer,String> f2){
        return f1.andThen(f2).apply(s);
    }
}
