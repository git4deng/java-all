package com.david.api.Extends;

/**
 * 在继承的关系中，“子类就是一个父类”。也就是说，子类可以被当做父类看待。
 例如父类是员工，子类是讲师，那么“讲师就是一个员工”。关系：is-a。

 定义父类的格式：（一个普通的类定义）
 public class 父类名称 {
 // ...
 }

 定义子类的格式：
 public class 子类名称 extends 父类名称 {
 // ...
 }
 * @author david
 * @create 2019-04-11 20:29
 */
public class E01Extends {
    public static void main(String[] args) {
        Teacher t=new Teacher();
        t.method();//子类调用父类方法
        //另外一个子类
        Assistant as=new Assistant();
        as.method();
    }
}
