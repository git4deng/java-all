package com.david.dataStructure.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * java.util.LinkedHashMap<K,V> entends HashMap<K,V>
    Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序。
    底层原理:
    哈希表+链表(记录元素的顺序)
 * @author david
 * @create 2019-04-15 21:46
 */
public class M02LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("a","a");
        map.put("c","c");
        map.put("b","b");
        map.put("a","d");
        System.out.println(map);// key不允许重复,无序 {a=d, b=b, c=c}

        LinkedHashMap<String,String> linked = new LinkedHashMap<>();
        linked.put("a","a");
        linked.put("c","c");
        linked.put("b","b");
        linked.put("a","d");
        System.out.println(linked);// key不允许重复,有序 {a=d, c=c, b=b}
    }
}
