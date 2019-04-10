package com.david.api.Static;

/**
 * 一旦使用static修饰成员方法，那么这就成为了静态方法。静态方法不属于对象，而是属于类的。

 如果没有static关键字，那么必须首先创建对象，然后通过对象才能使用它。
 如果有了static关键字，那么不需要创建对象，直接就能通过类名称来使用它。

 无论是成员变量，还是成员方法。如果有了static，都推荐使用类名称进行调用。
 静态变量：类名称.静态变量
 静态方法：类名称.静态方法()

 注意事项：
 1. 静态不能直接访问非静态。
 原因：因为在内存当中是【先】有的静态内容，【后】有的非静态内容。
 “先人不知道后人，但是后人知道先人。”
 2. 静态方法当中不能用this。
 原因：this代表当前对象，通过谁调用的方法，谁就是当前对象。
 * @author david
 * @create 2019-04-10 22:42
 */
public class S02StaticMethod {
    public static void main(String[] args) {
        UtilClass uc=new UtilClass();
        uc.commomMethod();

        // 对于静态方法来说，可以通过对象名进行调用，也可以直接通过类名称来调用。
        uc.staticMethod();//正确，不推荐，这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
        UtilClass.staticMethod();//正确，推荐
        // 对于本来当中的静态方法，可以省略类名称
        myMethod();
        S02StaticMethod.myMethod();//也可以完整的写出类名.
    }
    public static void myMethod(){
        System.out.println("自己的静态方法！");
    }
}
class UtilClass{
    private int number;
    private static int n;
    public void commomMethod(){
        System.out.println("这是普通方法！");
        // 成员方法可以访问静态变量
        System.out.println(n);
        // 成员方法可以访问成员变量
        System.out.println(number);
    }
    public static void staticMethod(){
        System.out.println("这是静态方法！");
        // 静态方法可以访问静态变量
        System.out.println(n);
        // 静态不能直接访问非静态【重点】
        //System.out.println(Number);//错误
        // 静态方法中不能使用this关键字。
        //System.out.println(this); // 错误写法！this值当前对象
    }

}
