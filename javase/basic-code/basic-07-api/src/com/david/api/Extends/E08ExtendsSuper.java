package com.david.api.Extends;

/**
 * super关键字的用法有三种：
 1. 在子类的成员方法中，访问父类的成员变量。
 2. 在子类的成员方法中，访问父类的成员方法。
 3. 在子类的构造方法中，访问父类的构造方法。
 * @author david
 * @create 2019-04-11 22:03
 */
public class E08ExtendsSuper {
}
class F8{
    int number=10;
    public void method(){
        System.out.println("父类方法。。。");
    }
}
class Z8 extends F8{
    int number=20;
    @Override
    public void method(){
        System.out.println(number);
        System.out.println(super.number);
        super.method();
        System.out.println("子类方法。。。");
    }

}