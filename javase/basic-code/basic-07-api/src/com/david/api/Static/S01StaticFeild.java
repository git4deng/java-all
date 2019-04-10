package com.david.api.Static;

/**
 * 如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类。多个对象共享同一份数据。
 * @author david
 * @create 2019-04-10 22:31
 */
public class S01StaticFeild {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.room="101";
        System.out.println(s1+s1.room);

        s1=new Student("david",21);
        System.out.println(s1+s1.room);
    }

}
class Student{
    private int id;
    private String name;
    private int age;
    public static String room;
    private static int idCounter=0;//学号计数器

    public Student() {
        this.id=++idCounter;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id=++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
