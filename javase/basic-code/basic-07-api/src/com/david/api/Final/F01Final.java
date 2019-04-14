package com.david.api.Final;

/**
 * final关键字代表最终、不可改变的。

 常见四种用法：
 1. 可以用来修饰一个类
 2. 可以用来修饰一个方法
 3. 还可以用来修饰一个局部变量
 4. 还可以用来修饰一个成员变量
 * @author david
 * @create 2019-04-12 22:03
 */
public class F01Final {
    public static void main(String[] args) {
        int num=10;
        System.out.println(num);
        num=20;
        System.out.println(num);

        // 一旦使用final用来修饰局部变量，那么这个变量就不能进行更改。
        final int n=100;
        System.out.println(n);
       // n=300;//报错

        // 正确写法！只要保证有唯一一次赋值即可
        final int num3;
        num3 = 30;

        // 对于基本类型来说，不可变说的是变量当中的数据不可改变
        // 对于引用类型来说，不可变说的是变量当中的地址值不可改变
        Student stu1 = new Student("赵丽颖");
        System.out.println(stu1);
        System.out.println(stu1.getName()); // 赵丽颖
        stu1 = new Student("霍建华");
        System.out.println(stu1);
        System.out.println(stu1.getName()); // 霍建华
        System.out.println("===============");

        final Student stu2 = new Student("高圆圆");
        // 错误写法！final的引用类型变量，其中的地址不可改变
//        stu2 = new Student("赵又廷");
        System.out.println(stu2.getName()); // 高圆圆
        stu2.setName("高圆圆圆圆圆圆");//但是地址指向对象可以改变
        System.out.println(stu2.getName()); // 高圆圆圆圆圆圆

    }





}
/**
当final关键字用来修饰一个方法的时候，这个方法就是最终方法，也就是不能被覆盖重写。
格式：
修饰符 final 返回值类型 方法名称(参数列表) {
    // 方法体
}
注意事项：
对于类、方法来说，abstract关键字和final关键字不能同时使用，因为矛盾。
 */
class Fu1{
    public final void method(){
        System.out.println("父类方法！");
    }
}
class Zi1 extends Fu1{
    //不能重写父类方法
//    public  void method(){
//
//    }
}
class Student {

    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/**
对于成员变量来说，如果使用final关键字修饰，那么这个变量也照样是不可变。

1. 由于成员变量具有默认值，所以用了final之后必须手动赋值，不会再给默认值了。
2. 对于final的成员变量，要么使用直接赋值，要么通过构造方法赋值。二者选其一。
3. 必须保证类当中所有重载的构造方法，都最终会对final的成员变量进行赋值。
 */
class Person {

    private final String name/* = "鹿晗"*/;

    public Person() {
        name = "关晓彤";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
}

