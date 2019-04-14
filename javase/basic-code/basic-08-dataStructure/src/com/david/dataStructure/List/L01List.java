package com.david.dataStructure.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * java.util.List接口 extends Collection接口
    List接口的特点:
     1.有序的集合,存储元素和取出元素的顺序是一致的(存储123 取出123)
     2.有索引,包含了一些带索引的方法
     3.允许存储重复的元素

 List接口中带索引的方法(特有)
     - public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
     - public E get(int index):返回集合中指定位置的元素。
     - public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
     - public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
     注意:
         操作索引的时候,一定要防止索引越界异常
         IndexOutOfBoundsException:索引越界异常,集合会报
         ArrayIndexOutOfBoundsException:数组索引越界异常
         StringIndexOutOfBoundsException:字符串索引越界异常
 * @author david
 * @create 2019-04-14 21:00
 */
public class L01List {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list);
        System.out.println("-------add()方法:将指定的元素，添加到该集合中的指定位置上");
        list.add(3,"CD");//插入到第4的位置，其余依次后移
        System.out.println(list);

        System.out.println("-------get()方法:返回集合中指定位置的元素");
        String s = list.get(3);
        System.out.println(s);

        System.out.println("-------remove()方法: 移除列表中指定位置的元素, 返回的是被移除的元素。");
        String remove = list.remove(3);
        System.out.println(remove);

        System.out.println("-------set()方法:用指定元素替换集合中指定位置的元素,返回值的更新前的元素");
        String f = list.set(5, "F");
        System.out.println(f);
        System.out.println(list);

        System.out.println("-------list的三种遍历方法");
        System.out.println("常规for循环");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("迭代器遍历");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("增强for循环");
        for (String s1 : list) {
            System.out.println(s1);
        }

    }



}
