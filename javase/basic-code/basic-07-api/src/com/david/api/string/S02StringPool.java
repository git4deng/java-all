package com.david.api.string;

/**
 * 字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中。

 对于基本类型来说，==是进行数值的比较。
 对于引用类型来说，==是进行【地址值】的比较。
 * @author david
 * @create 2019-04-10 16:16
 */
public class S02StringPool {
    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";//字符串常量，常量池只存在一个对应的字符串对象，那么地址肯定就是唯一的，所以str1和str2指向的是
        //同一个地址 所以== 返回true
        char[] c=new char[]{'a','b','c'};
        String s3=new String (c);

        System.out.println(s1==s2);

        System.out.println(s1==s3);
        System.out.println(s2==s3);
    }
}
