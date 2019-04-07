package com.david.day04.method;

/**
 * 打印指定次数的helloworld
 * @author david
 * @create 2019-04-07 21:57
 */
public class Order7MethodPrint {
    public static void main(String[] args) {
        print(5);
    }
    public static void print(int num){
        for (int i = 0; i < num; i++) {
            System.out.println("helloworld");
        }
    }
}
