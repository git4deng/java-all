package com.david.dataStructure.List;

import java.util.LinkedList;

/**
 * java.util.LinkedList集合 implements List接口
 LinkedList集合的特点:
 1.底层是一个链表结构:查询慢,增删快
 2.里边包含了大量操作首尾元素的方法
 注意:使用LinkedList集合特有的方法,不能使用多态

 - public void addFirst(E e):将指定元素插入此列表的开头。
 - public void addLast(E e):将指定元素添加到此列表的结尾。
 - public void push(E e):将元素推入此列表所表示的堆栈。

 - public E getFirst():返回此列表的第一个元素。
 - public E getLast():返回此列表的最后一个元素。

 - public E removeFirst():移除并返回此列表的第一个元素。
 - public E removeLast():移除并返回此列表的最后一个元素。
 - public E pop():从此列表所表示的堆栈处弹出一个元素。

 - public boolean isEmpty()：如果列表不包含元素，则返回true。
 * @author david
 * @create 2019-04-14 21:22
 */
public class L02LinkedList {
    public static void main(String[] args) {
        createLinkedList();
    }

    private static void createLinkedList() {
        LinkedList<String> list=new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);

        System.out.println("public void addFirst(E e):将指定元素插入此列表的开头。");
        list.addFirst("A");
        System.out.println(list);
        System.out.println("public void push(E e):将元素推入此列表所表示的堆栈。等效addFirst");
        list.push("AA");
        System.out.println(list);

        System.out.println("addLast(E e):将指定元素添加到此列表的结尾");
        list.addLast("E");
        System.out.println(list);

        System.out.println("E getFirst():返回此列表的第一个元素,getLast():返回此列表的最后一个元素");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println(" -public E removeFirst():移除并返回此列表的第一个元素。");
        String s = list.removeFirst();
        String s1 = list.removeLast();
        String pop = list.pop();//与removeFirst()等效

        System.out.println(list);
    }
}
