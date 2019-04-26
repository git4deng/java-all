package com.david.jdk8new.functionalInterface;

/**
 * 函数式接口:有且只有一个抽象方法的接口,称之为函数式接口
 当然接口中可以包含其他的方法(默认,静态,私有)

 @FunctionalInterface注解
 作用:可以检测接口是否是一个函数式接口
 是:编译成功
 否:编译失败(接口中没有抽象方法抽象方法的个数多余1个)
 * @author david
 * @create 2019-04-25 23:12
 */
@FunctionalInterface
public interface F01MyFunctionnalInterface {
    public abstract void method();
    public default void defaultMethod(){
        System.out.println("默认方法！");
    }
    public static void staticMethod(){
        System.out.println("静态方法！");
    }
    /**
     * jdk9的新特性
     */
//    private void privateMethod(){
//        System.out.println("私有方法！");
//    }

}
