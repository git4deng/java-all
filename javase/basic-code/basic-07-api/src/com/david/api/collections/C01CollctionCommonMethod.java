package com.david.api.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection接口
     所有单列集合的最顶层的接口,里边定义了所有单列集合共性的方法
     任意的单列集合都可以使用Collection接口中的方法

         共性的方法:
         public boolean add(E e)：  把给定的对象添加到当前集合中 。
         public void clear() :清空集合中所有的元素。
         public boolean remove(E e): 把给定的对象在当前集合中删除。
         public boolean contains(E e): 判断当前集合中是否包含给定的对象。
         public boolean isEmpty(): 判断当前集合是否为空。
         public int size(): 返回集合中元素的个数。
         public Object[] toArray(): 把集合中的元素，存储到数组中。
 * @author david
 * @create 2019-04-13 22:07
 */
public class C01CollctionCommonMethod {
    public static void main(String[] args) {
        /*
        public boolean add(E e)：  把给定的对象添加到当前集合中 。
            返回值是一个boolean值,一般都返回true,所以可以不用接收
         */
        System.out.println("-----------add方法------------");
        //使用多态创建集合对象
        Collection<String> c1=new ArrayList<>();
        System.out.println(c1);

        c1.add("a");
        c1.add("b");
        c1.add("c");
        System.out.println(c1);

        /*
         * public boolean remove(E e): 把给定的对象在当前集合中删除。
         返回值是一个boolean值,集合中存在元素,删除元素,返回true
         集合中不存在元素,删除失败,返回false
         */
        System.out.println("-----------remove方法------------");
        boolean b = c1.remove("b");
        System.out.println(b);// true
        b = c1.remove("b");
        System.out.println(b);//false

        /*
            public boolean contains(E e): 判断当前集合中是否包含给定的对象。
            包含返回true
            不包含返回false
         */
        System.out.println("-----------contains方法------------");
       b= c1.contains("b");
       System.out.println(b);//false
        b= c1.contains("a");
        System.out.println(b);//true

        //public boolean isEmpty(): 判断当前集合是否为空。 集合为空返回true,集合不为空返回false
        System.out.println("-----------isEmpty方法------------");
        b=c1.isEmpty();
        System.out.println(b);//false

        //public int size(): 返回集合中元素的个数。
        System.out.println("-----------size方法------------");
        System.out.println(c1.size());

        //public Object[] toArray(): 把集合中的元素，存储到数组中。
        System.out.println("-----------toArray方法------------");
        Object[] objects = c1.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        //public void clear() :清空集合中所有的元素。但是不删除集合,集合还存在
        System.out.println("-----------clear方法------------");
        c1.clear();
        System.out.println(c1);
        System.out.println(c1.isEmpty());
    }

}
