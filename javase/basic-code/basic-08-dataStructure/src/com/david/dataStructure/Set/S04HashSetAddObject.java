package com.david.dataStructure.Set;

import java.util.HashSet;
import java.util.Objects;

/**
 * HashSet存储自定义类型元素

 set集合报错元素唯一:
 存储的元素(String,Integer,...Student,Person...),必须重写hashCode方法和equals方法

 要求:
 同名同年龄的人,视为同一个人,只能存储一次
 * @author david
 * @create 2019-04-14 22:57
 */
public class S04HashSetAddObject {
    public static void main(String[] args) {
        //若果没有重写hashCode方法和equals方法，同名同年龄的人不被认为同一个人，而2个都保存成功！
        //没有重写hashcode方法，就调用Object的hashcode方法，返回的是该对象的在堆内存中的虚拟地址值
        //显然2个对象的地址值不相等，即hashcode不同，hashSet不会判定重复。
        System.out.println("-----------------未重写hashCode方法和equals方法的验证-----------");
        HashSet<Student> stus=new HashSet<>();
        Student david = new Student("david", 20);
        System.out.println(david.hashCode());//460141958
        boolean b = stus.add(david);
        System.out.println(b);

        david = new Student("david", 20);
        System.out.println(david.hashCode());//1163157884
        b=stus.add(david);
        System.out.println(b);
        System.out.println(stus);

        System.out.println("-----------------重写了hashCode方法和equals方法的验证-----------");
        HashSet<Teacher> tcs=new HashSet<>();
        Teacher t1=new Teacher("david",22);
        System.out.println(t1.hashCode());
        Teacher t2=new Teacher("david",22);
        System.out.println(t2.hashCode());

        b=tcs.add(t1);
        System.out.println(b);//ture

        b=tcs.add(t2);
        System.out.println(b);//false

        System.out.println(tcs);




    }
}
class Student{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
class Teacher{
    private String name;
    private Integer age;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Teacher() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name) &&
                Objects.equals(age, teacher.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
