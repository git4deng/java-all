package com.david.jdk8new.functionalInterface;

/**
 * 函数式接口的使用:一般可以作为方法的参数和返回值类型
 * @author david
 * @create 2019-04-25 23:16
 */
public class F02FIMainTest {
    public static void main(String[] args) {
        //匿名内部类方式调用
        show(new F01MyFunctionnalInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类的方式调用！");
            }
        });
        //lambda方式调用
        show(()->{
            System.out.println("lambda方式调用！");
        });
        //lambda简写
        show(()-> System.out.println("lambda简写的方式调用！"));

    }
    public static void show(F01MyFunctionnalInterface myInner){
        myInner.method();
    }
}
