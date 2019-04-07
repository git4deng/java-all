package com.david.day04.method;

/**
 * 判断2个数值是否相等。
 * @author david
 * @create 2019-04-07 21:50
 */
public class Order5MethodCompare {
    public static void main(String[] args) {
        boolean b=isSame(5,6);
        System.out.println(b);
    }
    public static boolean isSame(int a,int b){

        return a==b;
    }
}
