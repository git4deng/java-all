package com.david.day04.method;

/**
 * 有参数：小括号当中有内容，当一个方法需要一些数据条件，才能完成任务的时候，就是有参数。
 *  例如两个数字相加，必须知道两个数字是各自多少，才能相加。
 * 无参数：小括号当中留空。一个方法不需要任何数据条件，自己就能独立完成任务，就是无参数。
 *  例如定义一个方法，打印固定10次HelloWorld。
 * @author david
 * @create 2019-04-07 21:40
 */
public class Order3MethodParam {
    public static void main(String[] args) {
        printMethod();
        sum(5,6);
    }
    public  static  void printMethod(){
        for (int i = 0; i < 10; i++) {
            System.out.println("helloworld"+i);
        }
    }
    public static void sum(int a,int b){
        System.out.println("result:"+(a+b));
    }
}
