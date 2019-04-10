package com.david.api.ArrayList;

/**
 * 数组对象，引入ArrayList
 * 对象数组：定义一个数组，里面存储3个对象
 * @author david
 * @create 2019-04-09 22:35
 */
public class A01ObjectArray {
    public static void main(String[] args) {
        Person[] persons=new Person[3];

        Person p1=new Person("david1",22);
        Person p2=new Person("david2",23);
        Person p3=new Person("david3",24);
        // 将p1当中的地址值赋值到数组的0号元素位置
        persons[0]=p1;//地址
        persons[1]=p2;//地址
        persons[2]=p3;//地址

        System.out.println(persons[1]);
    }

}
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}