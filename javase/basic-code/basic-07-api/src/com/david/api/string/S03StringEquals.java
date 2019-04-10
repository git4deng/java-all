package com.david.api.string;

/**
 * ==是进行对象的地址值比较，如果确实需要字符串的内容比较，可以使用两个方法：

 public boolean equals(Object obj)：参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true；否则返回false。
 注意事项：
 1. 任何对象都能用Object进行接收。
 2. equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样。
 3. 如果比较双方一个常量一个变量，推荐把常量字符串写在前面。
 推荐："abc".equals(str)    不推荐：str.equals("abc")

 public boolean equalsIgnoreCase(String str)：忽略大小写，进行内容比较。
 * @author david
 * @create 2019-04-10 16:21
 */
public class S03StringEquals {
    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
        char[] c=new char[]{'a','b','c'};
        String s3=new String (c);

        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s1.equals(s3));//true

        //equals方法对字符串大小写敏感
        String s4="Abc";
        System.out.println(s1.equals(s4));//false
        System.out.println(s1.equalsIgnoreCase(s4));//true

        String s5=null;
       // System.out.println(s5.equals(s1));//空指针异常
        System.out.println(s1.equals(s5));//false

        String s6="a"+"bc";//字符串拼接返回的还是常量池的
        System.out.println(s1==s6);//true
        System.out.println(s1.equals(s6));//true

        String s7="a".concat("bc");
        System.out.println(s1==s7);//false
        System.out.println(s1.equals(s7));//true
        System.out.println(s1=="abc");//true




    }
}
