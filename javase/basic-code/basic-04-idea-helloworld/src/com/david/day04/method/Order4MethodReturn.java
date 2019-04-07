package com.david.day04.method;

/**
 * 题目要求：定义一个方法，用来【求出】两个数字之和。（你帮我算，算完之后把结果告诉我。）
 * 题目变形：定义一个方法，用来【打印】两个数字之和。（你来计算，算完之后你自己负责显示结果，不用告诉我。）
 * 注意事项：
 *   对于有返回值的方法，可以使用单独调用、打印调用或者赋值调用。
 *   但是对于无返回值的方法，只能使用单独调用，不能使用打印调用或者赋值调用。
 * @author david
 * @create 2019-04-07 21:45
 */
public class Order4MethodReturn {
    public static void main(String[] args) {
        sumNoRetrun(4,5);
        int a =sumRetrun(5,5);
        System.out.println(a);
    }
    public static void sumNoRetrun(int a,int b){
        System.out.println("结果是："+(a+b));
    }public static int sumRetrun(int a,int b){
        return a+b;
    }
}
