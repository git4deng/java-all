package com.david.web.reflect;

/**
 * 获取Class对象的方式：
    1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
    2. 类名.class：通过类名的属性class获取
    3. 对象.getClass()：getClass()方法在Object类中定义着
 * @author david
 * @create 2019-04-28 21:48
 */
public class R01GetClassWay {
    public static void main(String[] args) throws ClassNotFoundException {

        Class cls1 = Class.forName("com.david.web.reflect.Person");
        System.out.println(cls1);

        Class cls2 = Person.class;
        System.out.println(cls2);
        Person p=new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
        /*
            同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，
            不论通过哪一种方式获取的Class对象都是同一个
         */
        System.out.println(cls1==cls2);//true
        System.out.println(cls1==cls3);//true
        System.out.println(cls2==cls3);//true
    }
}
class Person{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public Person() {

    }
}
