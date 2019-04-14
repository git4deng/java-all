package com.david.dataStructure.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * - java.utils.Collections是集合工具类，用来对集合进行操作。部分方法如下：
 - public static <T> boolean addAll(Collection<T> c, T... elements):往集合中添加一些元素。
 - public static void shuffle(List<?> list) 打乱顺序:打乱集合顺序。
 * @author david
 * @create 2019-04-14 23:40
 */
public class C01CollectionsMethod {
    public static void main(String[] args) {
        //往集合中添加多个元素，常规方法：
        System.out.println("---往集合中添加多个元素，常规方法：---");
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
        list.clear();
        System.out.println("---往集合中添加多个元素，工具类方法：---");
        Collections.addAll(list,"a","b","c","d","e");
        System.out.println(list);

        System.out.println("---shuffle(List<?> list) 打乱顺序:打乱集合顺序---");
        Collections.shuffle(list);
        System.out.println(list);
        
        sortMethod();

    }
    // public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
    private static void sortMethod() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(list);//[1, 3, 2]
        Collections.sort(list);
        System.out.println(list);//默认是升序排序的

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("a");
        list02.add("c");
        list02.add("b");
        System.out.println(list02);//[a, c, b]

        Collections.sort(list02);
        System.out.println(list02);//[a, b, c]

        ArrayList<Person> list03 = new ArrayList<>();
        list03.add(new Person("张三",18));
        list03.add(new Person("李四",20));
        list03.add(new Person("王五",15));
        System.out.println(list03);//[Person{name='张三', age=18}, Person{name='李四', age=20}, Person{name='王五', age=15}]

        Collections.sort(list03);
        System.out.println(list03);

    }
    /**
     * - java.utils.Collections是集合工具类，用来对集合进行操作。部分方法如下：
     public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。

     Comparator和Comparable的区别
     Comparable:自己(this)和别人(参数)比较,自己需要实现Comparable接口,重写比较的规则compareTo方法
     Comparator:相当于找一个第三方的裁判,比较两个

     Comparator的排序规则:
     o1-o2:升序
     */
    private static void sortMethodAnother() {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(3);
        list01.add(2);
        System.out.println(list01);//[1, 3, 2]

        Collections.sort(list01, new Comparator<Integer>() {
            //重写比较的规则
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1-o2;//升序
                return o2-o1;//降序
            }
        });

        System.out.println(list01);

        ArrayList<Student> list02 = new ArrayList<>();
        list02.add(new Student("a迪丽热巴",18));
        list02.add(new Student("古力娜扎",20));
        list02.add(new Student("杨幂",17));
        list02.add(new Student("b杨幂",18));
        System.out.println(list02);

        /*Collections.sort(list02, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄升序排序
                return o1.getAge()-o2.getAge();
            }
        });*/

        //扩展:了解
        Collections.sort(list02, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄升序排序
                int result =  o1.getAge()-o2.getAge();
                //如果两个人年龄相同,再使用姓名的第一个字比较
                if(result==0){
                    result =  o1.getName().charAt(0)-o2.getName().charAt(0);
                }
                return  result;
            }

        });

        System.out.println(list02);
    }
}

/**
 * - java.utils.Collections是集合工具类，用来对集合进行操作。部分方法如下：
 public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。

 注意:
 sort(List<T> list)使用前提
 被排序的集合里边存储的元素,必须实现Comparable,重写接口中的方法compareTo定义排序的规则

 Comparable接口的排序规则:
 自己(this)-参数:升序 ，this-参数就是升序，参数-this就是降序
 */
class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    //重写排序的规则
    @Override
    public int compareTo(Person o) {
        //return 0;//认为元素都是相同的
        //自定义比较的规则,比较两个人的年龄(this,参数Person)
        //return this.getAge() - o.getAge();//年龄升序排序
        return o.getAge() - this.getAge();//年龄降序序排序
    }
}
class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
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
}