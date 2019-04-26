package com.david.basic.thread;

/**
 * 主线程:执行主(main)方法的线程

 单线程程序:java程序中只有一个线程
 执行从main方法开始,从上到下依次执行

 JVM执行main方法,main方法会进入到栈内存
 JVM会找操作系统开辟一条main方法通向cpu的执行路径
 cpu就可以通过这个路径来执行main方法
 而这个路径有一个名字,叫main(主)线程
 * @author david
 * @create 2019-04-17 23:19
 */
public class T01MainThread {
    public static void main(String[] args) {
        Person p1 = new Person("小强");
        p1.run();
        System.out.println(0/0);//ArithmeticException: / by zero
        Person p2 = new Person("旺财");
        p2.run();
    }
}
class Person{
    private String name;
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(name+"-->"+i);
        }
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
