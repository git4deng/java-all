package com.david.api.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * java.util.Iterator接口:迭代器(对集合进行遍历)
 有两个常用的方法
 boolean hasNext() 如果仍有元素可以迭代，则返回 true。
 判断集合中还有没有下一个元素,有就返回true,没有就返回false
 E next() 返回迭代的下一个元素。
 取出集合中的下一个元素
 Iterator迭代器,是一个接口,我们无法直接使用,需要使用Iterator接口的实现类对象,获取实现类的方式比较特殊
 Collection接口中有一个方法,叫iterator(),这个方法返回的就是迭代器的实现类对象
 Iterator<E> iterator() 返回在此 collection 的元素上进行迭代的迭代器。

 迭代器的使用步骤(重点):
 1.使用集合中的方法iterator()获取迭代器的实现类对象,使用Iterator接口接收(多态)
 2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
 3.使用Iterator接口中的方法next取出集合中的下一个元素
 * @author david
 * @create 2019-04-13 22:26
 */
public class C02Iterator {
    public static void main(String[] args) {

        Collection<String> c1=new ArrayList<>();
        c1.add("a");
        c1.add("b");
        c1.add("c");
        c1.add("d");
        c1.add("e");

        /*
            1.使用集合中的方法iterator()获取迭代器的实现类对象,使用Iterator接口接收(多态)
            注意:
                Iterator<E>接口也是有泛型的,迭代器的泛型跟着集合走,集合是什么泛型,迭代器就是什么泛型
         */
        //多态         接口            实现类对象
        Iterator<String> iterator = c1.iterator();
        /*
            发现使用迭代器取出集合中元素的代码,是一个重复的过程
            所以我们可以使用循环优化
            不知道集合中有多少元素,使用while循环
            循环结束的条件,hasNext方法返回false
         */
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
