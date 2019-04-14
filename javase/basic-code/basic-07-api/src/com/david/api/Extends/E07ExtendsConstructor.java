package com.david.api.Extends;

/**
 * 继承关系中，父子类构造方法的访问特点：

 1. 子类构造方法当中有一个默认隐含的“super()”调用，所以一定是先调用的父类构造，后执行的子类构造。
 2. 子类构造可以通过super关键字来调用父类重载构造。
 3. super的父类构造调用，必须是子类构造方法的第一个语句。不能一个子类构造调用多次super构造。
 总结：
 子类必须调用父类构造方法，不写则赠送super()；写了则用写的指定的super调用，super只能有一个，还必须是第一个。
 * @author david
 * @create 2019-04-11 21:57
 */
public class E07ExtendsConstructor {
    public static void main(String[] args) {
        Z7 z=new Z7();
    }

}
class F7{
    public F7(){
        System.out.println("父类无参构造！");
    }
    public F7(int m){
        System.out.println("父类无参构造！"+m);
    }

}
class Z7 extends F7{
    public Z7(){
        //隐式带了一个 super()；也可以指定父类的构造方法
        super(5);
        System.out.println("子类无参构造！");
    }
}