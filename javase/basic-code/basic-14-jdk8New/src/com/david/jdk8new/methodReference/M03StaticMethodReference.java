package com.david.jdk8new.methodReference;

/**
 *  通过类名引用静态成员方法
 类已经存在,静态成员方法也已经存在
 就可以通过类名直接引用静态成员方法
 * @author david
 * @create 2019-04-27 22:48
 */
public class M03StaticMethodReference {
    public static void main(String[] args) {
        System.out.println("----------标准格式lambda表达式---------");
        int n1 = method(-5, (i) -> {
            return Math.abs(i);
        });
        System.out.println(n1);
        System.out.println("----------简写的lambda表达式---------");
        int n2 = method(-6, i -> Math.abs(i));
        System.out.println(n2);
        System.out.println("----------lambda表达式优化版：静态方法引用的方式---------");
        int n3 = method(-9, Math::abs);
        System.out.println(n3);
    }
    public static int method(int n,Calcable c){
        return c.calsAbs(n);
    }
}
@FunctionalInterface
interface Calcable{
    //定义一个抽象方法,传递一个整数,对整数进行绝对值计算并返回
    int calsAbs(int number);
}