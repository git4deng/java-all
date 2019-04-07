package com.david.day04.method;

/**
 * 求出1-100的和
 * @author david
 * @create 2019-04-07 21:55
 */
public class Order6MethodSum {
    public static void main(String[] args) {
        System.out.println("结果是："+getSum());
    }
    public static int getSum(){
        int sum=0;
        for (int i = 0; i <= 100; i++) {
            sum+=i;
        }
        return sum;
    }
}
