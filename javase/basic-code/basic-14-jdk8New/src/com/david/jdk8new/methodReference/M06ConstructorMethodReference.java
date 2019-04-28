package com.david.jdk8new.methodReference;

/**
 * @author david
 * @create 2019-04-27 23:39
 */
public class M06ConstructorMethodReference {
    public static void main(String[] args) {
        System.out.println("------------lambda表达式的方式--------------");
        printPerson("david",(s)->new Person(s));
        System.out.println("------------构造器方法引用的方式--------------");
        /*
            使用方法引用优化Lambda表达式
            构造方法new Person(String name) 已知
            创建对象已知 new
            就可以使用Person引用new创建对象
         */
        printPerson("tom",Person::new);
    }
    public static void printPerson(String name,PersonBuilder pb){
        Person person = pb.buildPerson(name);
        System.out.println(person);
    }
}
class Person{
    private String name;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
@FunctionalInterface
interface PersonBuilder{
    Person buildPerson(String name);
}