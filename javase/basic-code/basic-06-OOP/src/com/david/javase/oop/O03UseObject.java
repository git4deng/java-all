package com.david.javase.oop;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 通常情况下，一个类并不能直接使用，需要根据类创建一个对象，才能使用。

 1. 导包：也就是指出需要使用的类，在什么位置。
 import 包名称.类名称;
 import com.david.javase.oop.O02ClassDefineStudent;
 对于和当前类属于同一个包的情况，可以省略导包语句不写。

 2. 创建，格式：
 类名称 对象名 = new 类名称();
 O02ClassDefineStudent stu = new O02ClassDefineStudent();

 3. 使用，分为两种情况：
 使用成员变量：对象名.成员变量名
 使用成员方法：对象名.成员方法名(参数)
 （也就是，想用谁，就用对象名点儿谁。）

 注意事项：
 如果成员变量没有进行赋值，那么将会有一个默认值，规则和数组一样。

 * @author david
 * @create 2019-04-08 20:52
 */
public class O03UseObject {

    public static void main(String[] args) {
        //创建对象
        O02ClassDefineStudent stu = new O02ClassDefineStudent();

        // 使用其中的成员变量，格式：
        // 对象名.成员变量名
        System.out.println(stu.name);
        System.out.println(stu.age);

        System.out.println("---------------------------");
        // 改变对象当中的成员变量数值内容
        // 将右侧的字符串，赋值交给stu对象当中的name成员变量
        stu.name="david";
        stu.age=21;
        System.out.println(stu.name);
        System.out.println(stu.age);
        System.out.println("---------------------------");

        // 使用对象的成员方法，格式：
        // 对象名.成员方法名()
        stu.eat();
        stu.sleep();
        stu.study();

    }


}
