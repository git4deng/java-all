package com.david.jdk8new.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Stream流的方式,遍历集合,对集合中的数据进行过滤
   Stream流是JDK1.8之后出现的
   关注的是做什么,而不是怎么做
 * @author david
 * @create 2019-04-27 18:27
 */
public class S02StreamCycle {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        System.out.println("list:"+list);
        System.out.println("------对list集合中的元素进行过滤,只要以张开头的元素,存储到一个新的集合中----");
        System.out.println("-----对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中----");
        list.stream().filter((s)->s.startsWith("张")).filter((s)->s.length()==3).forEach((s)-> System.out.println(s));



    }
}
