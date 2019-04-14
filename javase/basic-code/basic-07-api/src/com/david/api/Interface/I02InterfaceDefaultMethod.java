package com.david.api.Interface;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *  1. 接口的默认方法，可以通过接口实现类对象，直接调用。
    2. 接口的默认方法，也可以被接口实现类进行覆盖重写。
 * @author david
 * @create 2019-04-11 23:40
 */
public class I02InterfaceDefaultMethod {
    public static void main(String[] args) {
        MyInterfaceDefault a= new MyInterfaceDefaultImplA();
        a.method();
        a.methodDefault();
        System.out.println("======================");
        MyInterfaceDefault b=new MyInterfaceDefaultImplB();
        b.method();
        b.methodDefault();

    }
}
/**
 * 从Java 8开始，接口里允许定义默认方法。
 格式：
 public default 返回值类型 方法名称(参数列表) {
 方法体
 }

 备注：接口当中的默认方法，可以解决接口升级的问题。
 */
interface MyInterfaceDefault{
    public abstract void method();
    // 新添加的方法，改成默认方法
    public default void methodDefault(){
        System.out.println("接口的默认方法。。。。");
    };
}
class MyInterfaceDefaultImplA implements MyInterfaceDefault{

    @Override
    public void method() {
        System.out.println("A重写了接口的抽象方法");
    }
}class MyInterfaceDefaultImplB implements MyInterfaceDefault{

    @Override
    public void method() {
        System.out.println("B重写了接口的抽象方法");
    }

    @Override
    public void methodDefault() {
        System.out.println("B重写了接口的默认方法");
    }
}