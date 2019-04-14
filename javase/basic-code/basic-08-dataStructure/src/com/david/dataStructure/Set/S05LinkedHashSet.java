package com.david.dataStructure.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * java.util.LinkedHashSet集合 extends HashSet集合
 LinkedHashSet集合特点:
 底层是一个哈希表(数组+链表/红黑树)+链表:多了一条链表(记录元素的存储顺序),保证元素有序
 * @author david
 * @create 2019-04-14 23:15
 */
public class S05LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> hs=new HashSet<>();
        hs.add("david");
        hs.add("david");
        hs.add("tom");
        hs.add("jack");
        hs.add("peter");
        System.out.println(hs);// [tom, peter, david, jack]  无序不可重复的集合

        LinkedHashSet<String> lhs=new LinkedHashSet<>();
        lhs.add("david");
        lhs.add("david");
        lhs.add("tom");
        lhs.add("jack");
        lhs.add("peter");
        System.out.println(lhs);//[david, tom, jack, peter]  有序不可重复的集合

    }
}
