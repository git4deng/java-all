package com.david.api.collections.generic01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
    泛型的通配符:
     ?:代表任意的数据类型
     使用方式:
     不能创建对象使用
     只能作为方法的参数使用
 * @author david
 * @create 2019-04-14 0:01
 */
public class G05GenericWildcards {
    public static void main(String[] args) {
        System.out.println("---------·1.泛型通配符--------");
        List<Integer> li=new ArrayList<>();
        li.add(1);
        li.add(2);
        li.add(2);
        printArray(li);
        List<String> ls=new ArrayList<>();
        ls.add("a");
        ls.add("b");
        ls.add("c");
        ls.add("d");
        printArray(ls);
        System.out.println("---------·2.泛型限定--------");
        printArrayExtendsNumber(li);
        //printArrayExtendsNumber(ls);//报错
        //       printArraySuperNumber(li);//报错 Integer是Number的子类
//        printArraySuperNumber(ls);//报错

        /*
            类与类之间的继承关系
            Integer extends Number extends Object
            String extends Object
         */
    }
    /**
        定义一个方法,能遍历所有类型的ArrayList集合
        这时候我们不知道ArrayList集合使用什么数据类型,可以泛型的通配符?来接收数据类型
        注意:
            泛型没有继承概念的
     */
    private static void printArray(List<?> arr) {
        Iterator<?> it = arr.iterator();
        while(it.hasNext()){
            Object next = it.next();
            System.out.println(next);
        }
    }

    /**
     * 泛型的上限限定: ? extends E  代表使用的泛型只能是E类型的子类/本身
     泛型的下限限定: ? super E    代表使用的泛型只能是E类型的父类/本身
     * @param arr
     */
    // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    private static void printArrayExtendsNumber(List<? extends Number> arr){

    }
    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    private static void printArraySuperNumber(List<? super Number> arr){

    }
}
