package com.david.api.Extends;

/**
 * super关键字用来访问父类内容，而this关键字用来访问本类内容。用法也有三种：

 1. 在本类的成员方法中，访问本类的成员变量。
 2. 在本类的成员方法中，访问本类的另一个成员方法。
 3. 在本类的构造方法中，访问本类的另一个构造方法。
 在第三种用法当中要注意：
 A. this(...)调用也必须是构造方法的第一个语句，唯一一个。
 B. super和this两种构造调用，不能同时使用。
 * @author david
 * @create 2019-04-11 22:09
 */
public class E09ExtendsThis {
    public static void main(String[] args) {
        Z9 z=new Z9();
        z.method2();
        z.method();
    }
}
class F9{
    int n=30;
    public F9(){
        System.out.println("ffffffffff");
    }
}
class Z9 extends F9{

    public Z9(){
       // super();
        this(5);
    }
    public Z9(int a){
        this(a,5);
    }
    public Z9(int a,int b){
        super();
        System.out.println(a);
        System.out.println(b);
    }



    int n=10;
    public void method(){
        int n=20;
        System.out.println(n);//局部变量
        System.out.println(this.n);//成员变量
        System.out.println(super.n);//父类变量
    }
    public void method1(){
        System.out.println("m1....");
    }
    public void method2(){
        this.method1();
        System.out.println("m2....");
    }
}