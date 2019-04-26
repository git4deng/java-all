package com.david.basic.lambda;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 Lambda表达式有参数有返回值的练习
 需求:
 使用数组存储多个Person对象
 对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
 * @author david
 * @create 2019-04-20 13:58
 */
public class L03LambdaWithParamAndReturn {
    public static void main(String[] args) {
        Person[] ps={
                new Person("D1",22),
                new Person("D2",20),
                new Person("D3",14),
                new Person("D4",25)
        };

        //使用匿名内部类的方式
        AnnomuosMethod(ps);
        //使用lambda方式
        lambdaMethod(ps);
    }

    private static void AnnomuosMethod(Person[] ps) {
        System.out.println(Arrays.toString(ps));
        Arrays.sort(ps, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(Arrays.toString(ps));
    }

    private static void lambdaMethod(Person[] ps) {
        System.out.println(Arrays.toString(ps));
        Arrays.sort(ps,(Person o1, Person o2)->{
            return o2.getAge()-o1.getAge();
        });
        System.out.println(Arrays.toString(ps));

         /*
        Lambda表达式:是可推导,可以省略
        凡是根据上下文推导出来的内容,都可以省略书写
        可以省略的内容:
            1.(参数列表):括号中参数列表的数据类型,可以省略不写
            2.(参数列表):括号中的参数如果只有一个,那么类型和()都可以省略
            3.{一些代码}:如果{}中的代码只有一行,无论是否有返回值,都可以省略({},return,分号)
                注意:要省略{},return,分号必须一起省略
         */
        //lambda省略书写格式
        Arrays.sort(ps,(o1,o2)-> o1.getAge()-o2.getAge());
        System.out.println(Arrays.toString(ps));
    }
}
class Person{
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}