package com.david.api.Interface;

/**
 * 使用接口的时候，需要注意：

 1. 接口是没有静态代码块或者构造方法的。
 2. 一个类的直接父类是唯一的，但是一个类可以同时实现多个接口。
 格式：
 public class MyInterfaceImpl implements MyInterfaceA, MyInterfaceB {
 // 覆盖重写所有抽象方法
 }
 3. 如果实现类所实现的多个接口当中，存在重复的抽象方法，那么只需要覆盖重写一次即可。
 4. 如果实现类没有覆盖重写所有接口当中的所有抽象方法，那么实现类就必须是一个抽象类。
 5. 如果实现类锁实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写。
 6. 一个类如果直接父类当中的方法，和接口当中的默认方法产生了冲突，优先用父类当中的方法。
 * @author david
 * @create 2019-04-12 0:11
 */
public class I06InterfaceNotice {
    public static void main(String[] args) {
        Z z=new Z();
        z.methodDefault();
    }
}
interface MyInterface{
    //接口是没有静态代码块
//    static{
//
//    }
    //接口是没有构造方法
//    public MyInterface(){}
}
interface MyInterfaceA{
    public abstract void methodA();
    public abstract void method();
    public default void methodDefault(){
        System.out.println("A的默认方法");
    }
}
interface MyInterfaceb{
    public abstract void methodB();
    public abstract void method();
    public default void methodDefault(){
        System.out.println("B的默认方法");
    }
}
class F{
    public  void methodDefault(){
        System.out.println("父类的默认方法");
    }
}
class MyInterfaceImpl implements MyInterface,MyInterfaceA,MyInterfaceb{

    @Override
    public void methodA() {
        System.out.println("覆盖了methodA方法");
    }

    @Override
    public void method() {
        System.out.println("如果实现类所实现的多个接口当中，存在重复的抽象方法，那么只需要覆盖重写一次即可");
    }

    @Override
    public void methodDefault() {
        System.out.println("如果实现类锁实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写。");
    }

    @Override
    public void methodB() {
        System.out.println("覆盖了methodB方法");
    }
}

class Z extends F implements MyInterfaceA{

    @Override
    public void methodA() {

    }

    @Override
    public void method() {

    }
}
