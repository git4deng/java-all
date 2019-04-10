package com.david.api.string;

import java.util.Scanner;

/**
 * @author david
 * @create 2019-04-10 22:10
 */
public class S09StringCharCount {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        Scanner sc=new Scanner(System.in);
        String str = sc.next();

        char[] chars = str.toCharArray();
        int s=0,b=0,n=0,o=0;
        for (char c : chars) {
            if('a'<=c&&c<='z'){
                s++;
            }else if ('A'<=c&&c<='Z'){
                b++;
            }else if ('0'<=c&&c<='9'){
                n++;
            }else {
                o++;
            }
        }
        System.out.println("输入了总共"+str.length()+"个字符，其中：");
        System.out.println("小写字母："+s+"个");
        System.out.println("大写字母："+b+"个");
        System.out.println("数字："+n+"个");
        System.out.println("其它字符："+o+"个");

    }
}
