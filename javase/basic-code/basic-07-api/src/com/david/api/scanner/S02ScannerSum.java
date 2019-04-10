package com.david.api.scanner;

import java.util.Scanner;

/**
 *题目：
 键盘输入两个int数字，并且求出和值。

 思路：
 1. 既然需要键盘输入，那么就用Scanner
 2. Scanner的三个步骤：导包、创建、使用
 3. 需要的是两个数字，所以要调用两次nextInt方法
 4. 得到了两个数字，就需要加在一起。
 5. 将结果打印输出。
 * @author david
 * @create 2019-04-08 23:25
 */
public class S02ScannerSum {
    public static void main(String[] args) {
        // 备注：System.in代表从键盘进行输入
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int a=scan.nextInt();
        System.out.println("请输入第二个数字：");
        int b=scan.nextInt();
        System.out.println("和为："+(a+b));


    }
}
