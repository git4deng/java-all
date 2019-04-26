package com.david.jdk8new.lambda;

/**
 * 例如java.lang.Runnable接口就是一个函数式接口，
 假设有一个startThread方法使用该接口作为参数，那么就可以使用Lambda进行传参。
 这种情况其实和Thread类的构造方法参数为Runnable没有本质区别。
 * @author david
 * @create 2019-04-25 23:40
 */
public class L03LambdaRunnable {
    public static void main(String[] args) {

        startRunnable(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"：匿名内部类的方式运行。。。。");
            }
        });

        startRunnable(()-> {System.out.println(Thread.currentThread().getName()+":多线程的lambda表达式运行！");});

        startRunnable(()-> System.out.println(Thread.currentThread().getName()+":多线程的lambda表达式运行！"));
    }
    public static void startRunnable(Runnable run){
        new Thread(run).start();
    }
}
