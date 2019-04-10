package com.david.api.string;

/**
 * 分割字符串的方法：
 public String[] split(String regex)：按照参数的规则，将字符串切分成为若干部分。

 注意事项：
 split方法的参数其实是一个“正则表达式”，今后学习。
 如果按照英文句点“.”进行切分，必须写"\\."（两个反斜杠）
 * @author david
 * @create 2019-04-10 21:55
 */
public class S07StringSplit {
    public static void main(String[] args) {
        String s1="aaa,bbb,ccc";
        String[] ss1 = s1.split(",");
        for (int i = 0; i < ss1.length; i++) {
            System.out.println(ss1[i]);
        }
        System.out.println("=====================");
        String s2="ddd eee fff";
        String[] ss2 = s2.split(" ");
        for (int i = 0; i < ss2.length; i++) {
            System.out.println(ss2[i]);
        }
        System.out.println("=====================");
        String s3="ggg.hhh.iii";
        String[] ss3= s3.split("\\.");
        for (int i = 0; i < ss3.length; i++) {
            System.out.println(ss3[i]);
        }

    }
}
