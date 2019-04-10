package com.david.api.Static;

/**
 * 静态代码块的格式是：

 public class 类名称 {
 static {
 // 静态代码块的内容
 }
 }

 特点：当第一次用到本类时，静态代码块执行唯一的一次。
 静态内容总是优先于非静态，所以静态代码块比构造方法先执行。

 静态代码块的典型用途：
 用来一次性地对静态成员变量进行赋值。
 * @author david
 * @create 2019-04-10 23:42
 */
public class S03StaticBlock{
    public static void main(String[] args) {
        Person p1=new Person();
        Person p2=new Person();

    }
}
class Person{

    static {
        System.out.println("这是来自静态块的输出。。。。");
    }
   public Person(){
       System.out.println("这是来之无参构造的参数。。。");
    }
}