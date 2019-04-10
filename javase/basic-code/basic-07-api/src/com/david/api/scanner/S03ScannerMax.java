package com.david.api.scanner;

import java.util.Scanner;

/**
 *题目：
 键盘输入三个int数字，然后求出其中的最大值。

 思路：
 1. 既然是键盘输入，肯定需要用到Scanner
 2. Scanner三个步骤：导包、创建、使用nextInt()方法
 3. 既然是三个数字，那么调用三次nextInt()方法，得到三个int变量
 4. 无法同时判断三个数字谁最大，应该转换成为两个步骤：
 4.1 首先判断前两个当中谁最大，拿到前两个的最大值
 4.2 拿着前两个中的最大值，再和第三个数字比较，得到三个数字当中的最大值
 5. 打印最终结果
 * @author david
 * @create 2019-04-08 23:25
 */
public class S03ScannerMax {
    public static void main(String[] args) {
        // 备注：System.in代表从键盘进行输入
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int a=scan.nextInt();
        System.out.println("请输入第二个数字：");
        int b=scan.nextInt();
        System.out.println("请输入第三个数字：");
        int c=scan.nextInt();
        int max=a;

        if(max<b) max=b;
        if(max<c) max=c;

        System.out.println("最大值为："+max);


    }
}
