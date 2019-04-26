package com.david.ioStream.objectStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 练习：序列化集合
     当我们想在文件中保存多个对象的时候
     可以把多个对象存储到一个集合中
     对集合进序列化和反序列化
 分析:
     1.定义一个存储Person对象的ArrayList集合
     2.往ArrayList集合中存储Person对象
     3.创建一个序列化流ObjectOutputStream对象
     4.使用ObjectOutputStream对象中的方法writeObject,对集合进行序列化
     5.创建一个反序列化ObjectInputStream对象
     6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
     7.把Object类型的集合转换为ArrayList类型
     8.遍历ArrayList集合
     9.释放资源
 * @author david
 * @create 2019-04-23 23:20
 */
public class O03Test {
    public static final String PATH="basic-12-IOStream";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Person> persons=new ArrayList<>();
        persons.add(new Person("小明",22));
        persons.add(new Person("小花",23));
        persons.add(new Person("小伟",24));

        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(PATH+"\\persons.txt"));
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(PATH+"\\persons.txt"));
        oos.writeObject(persons);
        List<Person> o = (List<Person>) ois.readObject();
        ois.close();
        oos.close();
        System.out.println(o);
    }
}
