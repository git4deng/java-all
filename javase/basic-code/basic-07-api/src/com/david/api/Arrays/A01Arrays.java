package com.david.api.Arrays;

import java.util.Arrays;

/**
 * java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。

 public static String toString(数组)：将参数数组变成字符串（按照默认格式：[元素1, 元素2, 元素3...]）
 public static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序。

 备注：
 1. 如果是数值，sort默认按照升序从小到大
 2. 如果是字符串，sort默认按照字母升序
 3. 如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（今后学习）
 * @author david
 * @create 2019-04-10 23:58
 */
public class A01Arrays {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4};
        String s = Arrays.toString(arr1);
        System.out.println(s);

        int[] arr2={4,1,3,2,5,1,2};
        System.out.println("排序前："+Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println("排序后："+Arrays.toString(arr2));

        String[] strs={"小明","aa","cc","bb"};
        System.out.println("排序前："+Arrays.toString(strs));
        Arrays.sort(strs);
        System.out.println("排序后："+Arrays.toString(strs));



    }
}
