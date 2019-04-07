package com.david.se.array;

/**
 数组常见异常
 数组的索引编号从0开始，一直到“数组的长度-1”为止。

 如果访问数组元素的时候，索引编号并不存在，那么将会发生
 数组索引越界异常
 ArrayIndexOutOfBoundsException
 所有的引用类型变量，都可以赋值为一个null值。但是代表其中什么都没有。

 数组必须进行new初始化才能使用其中的元素。
 如果只是赋值了一个null，没有进行new创建，
 那么将会发生：
 空指针异常 NullPointerException

 */
public class Array07Exceptions {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        System.out.println(arr1[3]);//java.lang.ArrayIndexOutOfBoundsException: 3
        arr1=null;
        System.out.println(arr1[0]);//java.lang.NullPointerException

    }
}
