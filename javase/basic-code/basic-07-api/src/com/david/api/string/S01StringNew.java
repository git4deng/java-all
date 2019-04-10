package com.david.api.string;

/**
 * java.lang.String类代表字符串。
 API当中说：Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
 其实就是说：程序当中所有的双引号字符串，都是String类的对象。（就算没有new，也照样是。）

 字符串的特点：
 1. 字符串的内容永不可变。【重点】
 2. 正是因为字符串不可改变，所以字符串是可以共享使用的。
 3. 字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组。

 创建字符串的常见3+1种方式。
 三种构造方法：
 public String()：创建一个空白字符串，不含有任何内容。
 public String(char[] array)：根据字符数组的内容，来创建对应的字符串。
 public String(byte[] array)：根据字节数组的内容，来创建对应的字符串。
 一种直接创建：
 String str = "Hello"; // 右边直接用双引号

 注意：直接写上双引号，就是字符串对象。
 * @author david
 * @create 2019-04-10 16:09
 */
public class S01StringNew {
    public static void main(String[] args) {
        String str1=new String();
        System.out.println("str1:"+str1);

        char[] chars={'A','B','C'};
        String str2=new String(chars);
        System.out.println("str2:"+str2);

        byte[] bs={1,2,3};
        String str3=new String(bs);
        System.out.println("str3:"+str3);

        String str4="david";
        System.out.println("str4:"+str4);

    }
}
