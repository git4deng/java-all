package com.david.api.anonymous;

import java.util.Scanner;

/**
 * @author david
 * @create 2019-04-09 10:05
 */
public class A02AnonymousScannerUse {
    public static void main(String[] args) {
        //普通方式使用Scanner
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入：");
//        String next = sc.next();
//        System.out.println("您输入的是："+next);


//        System.out.println("请输入：");
//        String str = new Scanner(System.in).next();
//        System.out.println("您输入的是："+str);

        //使用普通方式传参
//        Scanner sc=new Scanner(System.in);
//        methodParam(sc);
        //匿名方式传参
 //       methodParam(new Scanner(System.in));
        String str = getScanner().next();
        System.out.println("您输入的是："+str);
    }

    public static void methodParam(Scanner sc){
        String str = sc.next();
        System.out.println("您输入的是："+str);
    }
    public static Scanner getScanner(){
//        Scanner sc=new Scanner(System.in);
//        return  sc;
        return new Scanner(System.in);
    }
}
