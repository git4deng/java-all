package com.david.day04.method;

/**
 *  方法的练习：打印一个矩形
 * @author david
 * @create 2019-04-07 21:21
 */
public class Order1MethodWithFor {
    public static void main(String[] args) {
        printMethod();
    }
    public static void printMethod(){
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 20; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
