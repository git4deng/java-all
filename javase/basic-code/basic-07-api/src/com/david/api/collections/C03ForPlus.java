package com.david.api.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环:底层使用的也是迭代器,使用for循环的格式,简化了迭代器的书写
 是JDK1.5之后出现的新特性
 Collection<E>extends Iterable<E>:所有的单列集合都可以使用增强for
 public interface Iterable<T>实现这个接口允许对象成为 "foreach" 语句的目标。

 增强for循环:用来遍历集合和数组

 格式:
 for(集合/数组的数据类型 变量名: 集合名/数组名){
 sout(变量名);
 }
 * @author david
 * @create 2019-04-13 23:03
 */
public class C03ForPlus {
    public static void main(String[] args) {
        System.out.println("使用增强for循环遍历数组");
        arrayFor();
        System.out.println("使用增强for循环遍历集合");
       collectionFor();
    }

    private static void collectionFor() {
        Collection<String> c1=new ArrayList<>();
        c1.add("1");
        c1.add("2");
        c1.add("3");
        c1.add("4");
        c1.add("5");
        c1.add("6");
        for (String s : c1) {
            System.out.println(s);
        }
    }

    private static void arrayFor() {
        int[] arr={1,2,3,4,5};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
