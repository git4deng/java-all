package com.david.jdk8new.methodReference;

/**
 * 数组的构造器引用
 * @author david
 * @create 2019-04-27 23:48
 */
public class M07ArrayMethodReference {
    public static void main(String[] args) {
        Integer[] i1 = getIntegers(5, (n) -> new Integer[n]);
        System.out.println(i1.length);
        /*
            使用方法引用优化Lambda表达式
            已知创建的就是int[]数组
            数组的长度也是已知的
            就可以使用方法引用
            int[]引用new,根据参数传递的长度来创建数组
         */
        Integer[] i2 = getIntegers(6, Integer[]::new);
        System.out.println(i2.length);
    }
    public static Integer[] getIntegers(Integer length,ArrayBuilder ab){
        return ab.builderArray(length);
    }
}
@FunctionalInterface
interface ArrayBuilder{
    Integer[] builderArray(Integer length);
}