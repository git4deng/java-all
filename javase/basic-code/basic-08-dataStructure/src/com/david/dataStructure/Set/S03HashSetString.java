package com.david.dataStructure.Set;
import java.util.HashSet;
import java.util.Set;

/**
 * 首先获取存储元素的hash值，在集合中找对应hash值的链表，如果存在则调用equals方法对元素进行比较，如果equals方法返回true则表示元素重复
 * 添加失败。如果返回true则表示元素不相等，不重复添加成功！
 * @author david
 * @create 2019-04-14 22:06
 */
public class S03HashSetString {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        String s1=new String("abc");
        String s2=new String("abc");
        //s1、s2、"abc"的hash值相等 96354,调用equals方法进行判断
        set.add(s1);
        set.add(s2);
        set.add("abc");
        //重地 通话 2个字符串的hash值也是相等的 1179395
        set.add("重地");
        set.add("通话");
        System.out.println(set);
    }
}
