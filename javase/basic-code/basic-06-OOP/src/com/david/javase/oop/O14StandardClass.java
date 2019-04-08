package com.david.javase.oop;

/**
 * 一个标准的类通常要拥有下面四个组成部分：

 1. 所有的成员变量都要使用private关键字修饰
 2. 为每一个成员变量编写一对儿Getter/Setter方法
 3. 编写一个无参数的构造方法
 4. 编写一个全参数的构造方法

 这样标准的类也叫做Java Bean
 * @author david
 * @create 2019-04-08 23:10
 */
public class O14StandardClass {
    public static void main(String[] args) {
        StudentB stu1 = new StudentB();
        stu1.setName("迪丽热巴");
        stu1.setAge(20);
        System.out.println("姓名：" + stu1.getName() + "，年龄：" + stu1.getAge());
        System.out.println("=================");

        StudentB stu2 = new StudentB("古力娜扎", 21);
        System.out.println("姓名：" + stu2.getName() + "，年龄：" + stu2.getAge());
        stu2.setAge(22);
        System.out.println("姓名：" + stu2.getName() + "，年龄：" + stu2.getAge());
    }
}
class StudentB{
    private String name;
    private int age;

    public StudentB() {
    }

    public StudentB(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}