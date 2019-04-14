package com.david.api.Interface;

/**
 * 1. 类与类之间是单继承的。直接父类只有一个。
 2. 类与接口之间是多实现的。一个类可以实现多个接口。
 3. 接口与接口之间是多继承的。

 注意事项：
 1. 多个父接口当中的抽象方法如果重复，没关系。
 2. 多个父接口当中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写，【而且带着default关键字】。
 * @author david
 * @create 2019-04-12 0:24
 */
public class I07InterfaceAndExtendsRelations {
}
interface A{
    public abstract void a();
    public default void defaultMethod(){
        System.out.println("aaaaa");
    }
}
interface B{
    public abstract void b();
    public default void defaultMethod(){
        System.out.println("bbbb");
    }
}
interface C{
    public abstract void c();
    public default void defaultMethod(){
        System.out.println("cccc");
    }
}
interface D extends A,B,C{

    @Override
    public default void defaultMethod() {
        System.out.println("ddddddd");
    }
}
