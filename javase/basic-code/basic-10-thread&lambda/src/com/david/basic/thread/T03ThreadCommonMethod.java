package com.david.basic.thread;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 *
 * @author david
 * @create 2019-04-18 20:15
 */
public class T03ThreadCommonMethod {
    public static void main(String[] args) {

        System.out.println("--------------获取线程名称方法-------------");
        new MyThreadGetName().start();
        String mainName = Thread.currentThread().getName();
        System.out.println(mainName);//main

        System.out.println("--------------设置线程名称方法-------------");
        MyThreadSetName t1 = new MyThreadSetName();
        t1.setName("小强");
        t1.start();
        new MyThreadSetName("David").start();

        System.out.println("--------------sleep方法-------------");
        /*
            public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
            毫秒数结束之后,线程继续执行
         */
        for (int i = 0; i < 60; i++) {
            System.out.println("i:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
/**
 * 获取线程的名称:
 1.使用Thread类中的方法getName()
 String getName() 返回该线程的名称。
 2.可以先获取到当前正在执行的线程,使用线程中的方法getName()获取线程的名称
 static Thread currentThread() 返回对当前正在执行的线程对象的引用。
 */
class MyThreadGetName extends Thread{
    @Override
    public void run() {
        String name = getName();
        System.out.println("name:"+name);//Thread-0

        System.out.println(Thread.currentThread().getName());//Thread-0
    }
}

/**
 * 设置线程的名称:(了解)
 1.使用Thread类中的方法setName(名字)
 void setName(String name) 改变线程名称，使之与参数 name 相同。
 2.创建一个带参数的构造方法,参数传递线程的名称;调用父类的带参构造方法,把线程名称传递给父类,让父类(Thread)给子线程起一个名字
 Thread(String name) 分配新的 Thread 对象。
 */
class MyThreadSetName extends Thread{
    public MyThreadSetName() {
    }

    public MyThreadSetName(String name) {
        super(name);//把线程名称传递给父类,让父类(Thread)给子线程起一个名字
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
