package com.david.api.ArrayList;

import java.util.ArrayList;

/**
 * ArrayList当中的常用方法有：

 public boolean add(E e)：向集合当中添加元素，参数的类型和泛型一致。返回值代表添加是否成功。
 备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值可用可不用。
 但是对于其他集合（今后学习）来说，add添加动作不一定成功。

 public E get(int index)：从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素。

 public E remove(int index)：从集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素。

 public int size()：获取集合的尺寸长度，返回值是集合中包含的元素个数。
 * @author david
 * @create 2019-04-09 22:52
 */
public class A03ArrayListMethods {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);


        boolean b = list.add("a");
        System.out.println(list);
        System.out.println(b);

        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);

        String str = list.get(3);
        System.out.println(str);

        String remove = list.remove(2);
        System.out.println(remove);
        System.out.println(list);

        int size = list.size();
        System.out.println(size);

        //遍历集合
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
