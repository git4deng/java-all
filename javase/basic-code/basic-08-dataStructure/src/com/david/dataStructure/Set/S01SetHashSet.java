package com.david.dataStructure.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * java.util.Set接口 extends Collection接口
 Set接口的特点:
 1.不允许存储重复的元素
 2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历
 java.util.HashSet集合 implements Set接口
 HashSet特点:
 1.不允许存储重复的元素
 2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历
 3.是一个无序的集合,存储元素和取出元素的顺序有可能不一致
 4.底层是一个哈希表结构(查询的速度非常的快)
 * @author david
 * @create 2019-04-14 21:39
 */
public class S01SetHashSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        System.out.println("-------------add方法-----------------");
        boolean b = set.add("a");
        System.out.println(b);
        b = set.add("a");//添加不成功返回false
        System.out.println(b);
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println("-------------2种方式遍历-----------------");
        Iterator<String> it =   set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for (String s : set) {
            System.out.println(s);
        }

    }
}
