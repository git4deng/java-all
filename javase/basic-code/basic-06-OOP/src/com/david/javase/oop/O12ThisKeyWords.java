package com.david.javase.oop;

/**
 * 当方法的局部变量和类的成员变量重名的时候，根据“就近原则”，优先使用局部变量。
 如果需要访问本类当中的成员变量，需要使用格式：
 this.成员变量名

 “通过谁调用的方法，谁就是this。”
 * @author david
 * @create 2019-04-08 22:53
 */
public class O12ThisKeyWords {
    public static void main(String[] args) {
        Personal person = new Personal();
        // 设置我自己的名字
        person.name = "王健林";
        person.sayHello("王思聪");

        System.out.println(person); // 地址值
    }
}
class Personal{
    String name; // 我自己的名字

    // 参数name是对方的名字
    // 成员变量name是自己的名字
    public void sayHello(String name) {
        System.out.println(name + "，你好。我是" + this.name);
        System.out.println(this);
    }
}