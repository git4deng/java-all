package com.david.api.ArrayList;

import java.util.ArrayList;
import java.util.Random;

/**
 * 自定义4个学生对象，添加到集合，并遍历
 * @author david
 * @create 2019-04-09 23:07
 */
public class A05ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> stus=new ArrayList<>();
        stus.add(new Student("a",20));
        stus.add(new Student("b",21));
        stus.add(new Student("c",22));
        stus.add(new Student("d",23));

        System.out.println(stus);

        System.out.println("-------------------");
        for (Student student : stus) {
            System.out.println(student.getName());
        }
    }
}
class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}