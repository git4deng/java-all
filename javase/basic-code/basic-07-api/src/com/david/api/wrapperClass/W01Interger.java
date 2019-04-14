package com.david.api.wrapperClass;

import java.util.ArrayList;

/**
 * 装箱:把基本类型的数据,包装到包装类中(基本类型的数据->包装类)
 构造方法:
 Integer(int value) 构造一个新分配的 Integer 对象，它表示指定的 int 值。
 Integer(String s) 构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值。
 传递的字符串,必须是基本类型的字符串,否则会抛出异常 "100" 正确  "a" 抛异常
 静态方法:
 static Integer valueOf(int i) 返回一个表示指定的 int 值的 Integer 实例。
 static Integer valueOf(String s) 返回保存指定的 String 的值的 Integer 对象。
 拆箱:在包装类中取出基本类型的数据(包装类->基本类型的数据)
 成员方法:
 int intValue() 以 int 类型返回该 Integer 的值。
 * @author david
 * @create 2019-04-13 21:34
 */
public class W01Interger {
    public static void main(String[] args) {
        //装箱:把基本类型的数据,包装到包装类中(基本类型的数据->包装类)
        //构造方法
        Integer n1 = new Integer(1);
        System.out.println(n1);
        Integer n2 = new Integer("1");
        System.out.println(n2);
        //静态方法
        Integer n3 = Integer.valueOf("123");
//        Integer n = Integer.valueOf("a");//java.lang.NumberFormatException
        System.out.println(n3);

        Integer n4 = Integer.valueOf(123);
        System.out.println(n4);
        //拆箱
        int n5 = n1.intValue();
        System.out.println(n5);

        System.out.println("----------自动装箱和自动拆箱操作-----");
        autoConverse();

        System.out.println("----------基本类型与字符串进行转换-----");
        autoConverseInt2String();
    }

    /**
     * 基本类型与字符串类型之间的相互转换
     基本类型->字符串(String)
     1.基本类型的值+""  最简单的方法(工作中常用)
     2.包装类的静态方法toString(参数),不是Object类的toString() 重载
     static String toString(int i) 返回一个表示指定整数的 String 对象。
     3.String类的静态方法valueOf(参数)
     static String valueOf(int i) 返回 int 参数的字符串表示形式。
     字符串(String)->基本类型
     使用包装类的静态方法parseXXX("字符串");
     Integer类: static int parseInt(String s)
     Double类: static double parseDouble(String s)
     */
    private static void autoConverseInt2String() {
        String str="100";
        System.out.println("基本类型->字符串(String)");
        int n1=100;
        String s1=n1+"";//新对象
        System.out.println(s1==str);
        System.out.println(s1+200);//100200

        String s2 = Integer.toString(200);
        System.out.println(s2+200);//200200

        String s3 = String.valueOf(300);
        System.out.println(s3+300);//300300

        System.out.println("字符串(String)->基本类型");
        n1 = Integer.parseInt(s1);
        System.out.println(n1);
    }

    /**
     * 自动装箱与自动拆箱:基本类型的数据和包装类之间可以自动的相互转换
     JDK1.5之后出现的新特性
     */
    private static void autoConverse() {
        /*
            自动装箱:直接把int类型的整数赋值包装类
            Integer in = 1; 就相当于 Integer in = new Integer(1);
         */
        Integer n1=1;

        /*
            自动拆箱:n1是包装类,无法直接参与运算,可以自动转换为基本数据类型,在进行计算
            n1+2;就相当于 n1.intVale() + 2 = 3
            n1 = n1.intVale() + 2 = 3 又是一个自动装箱
         */
        n1=n1+2;

        ArrayList<Integer> list = new ArrayList<>();
        /*
            ArrayList集合无法直接存储整数,可以存储Integer包装类
         */
        list.add(1); //-->自动装箱 list.add(new Integer(1));

        int a = list.get(0); //-->自动拆箱  list.get(0).intValue();
    }
}
