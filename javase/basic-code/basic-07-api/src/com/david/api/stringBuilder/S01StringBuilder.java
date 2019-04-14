package com.david.api.stringBuilder;

/**
 * java.lang.StringBuilder类:字符串缓冲区,可以提高字符串的效率
 构造方法:
 StringBuilder() 构造一个不带任何字符的字符串生成器，其初始容量为 16 个字符。
 StringBuilder(String str) 构造一个字符串生成器，并初始化为指定的字符串内容。

 StringBuilder的常用方法:
 public StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身。

 * @author david
 * @create 2019-04-13 21:05
 */
public class S01StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        int capacity = sb.capacity();
        System.out.println("默认容量："+capacity);

        sb=new StringBuilder("hello");
        System.out.println(sb);
        System.out.println(sb.capacity());//带参构造器的初始化容量是 str的长度+16

        System.out.println("-----------常用方法----------");
        appendMethod();
        toStringMethod();
    }

    /**
     * StringBuilder和String可以相互转换:
     String->StringBuilder:可以使用StringBuilder的构造方法
     StringBuilder(String str) 构造一个字符串生成器，并初始化为指定的字符串内容。
     StringBuilder->String:可以使用StringBuilder中的toString方法
     public String toString()：将当前StringBuilder对象转换为String对象。
     */
    private static void toStringMethod() {
        String str="hello";
        StringBuilder sb=new StringBuilder(str);//转换成StrigBuilder
        sb.append(",world!");
        System.out.println(sb);
        str = sb.toString();//转换成String
        System.out.println(str);
    }

    private static void appendMethod() {
        StringBuilder sb=new StringBuilder();
        //append方法返回的是this,使用append方法无需接收返回值
        sb.append("abc");
        System.out.println(sb);

        /*
            链式编程:方法返回值是一个对象,可以继续调用方法
         */
        System.out.println("abc".toUpperCase().toLowerCase().toUpperCase().toLowerCase().toUpperCase());
        sb.append(1).append('a').append(1.1f).append(2.2).append(5l).append("abc");
        System.out.println(sb);
    }
}
