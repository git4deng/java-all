package com.david.dataStructure.Map;

import java.util.*;

/**
 * java.util.Map<k,v>集合
 Map集合的特点:
 1.Map集合是一个双列集合,一个元素包含两个值(一个key,一个value)
 2.Map集合中的元素,key和value的数据类型可以相同,也可以不同
 3.Map集合中的元素,key是不允许重复的,value是可以重复的
 4.Map集合中的元素,key和value是一一对应
 java.util.HashMap<k,v>集合 implements Map<k,v>接口
 HashMap集合的特点:
 1.HashMap集合底层是哈希表:查询的速度特别的快
 JDK1.8之前:数组+单向链表
 JDK1.8之后:数组+单向链表|红黑树(链表的长度超过8):提高查询的速度
 2.hashMap集合是一个无序的集合,存储元素和取出元素的顺序有可能不一致
 java.util.LinkedHashMap<k,v>集合 extends HashMap<k,v>集合
 LinkedHashMap的特点:
 1.LinkedHashMap集合底层是哈希表+链表(保证迭代的顺序)
 2.LinkedHashMap集合是一个有序的集合,存储元素和取出元素的顺序是一致的
 * @author david
 * @create 2019-04-15 20:17
 */
public class M01HashMap {
    public static void main(String[] args) {
        System.out.println("-----put方法-----");
        puthMethod();
        System.out.println("-----remove方法-----");
        removeMethod();
        System.out.println("-----get方法-----");
        getMethod();
        System.out.println("-----containsKey方法-----");
        containsKeysMethod();
        System.out.println("-----遍历方法1-----");
        keySetMethod();
        System.out.println("-----遍历方法2-----");
        entrySetMethod();
        System.out.println("-----hashMap存储自定义对象-----");
        hashMapSavePerson();
        System.out.println("-----hashMap存储自定义对象,对象作为key-----");
        hashMapSavePersonAskey();
    }
    /**
        HashMap存储自定义类型键值
        key:Person类型
            Person类就必须重写hashCode方法和equals方法,以保证key唯一
        value:String类型
            可以重复
     */
    private static void hashMapSavePersonAskey() {
        Map<Person,String> persons=new HashMap<>();
        persons.put(new Person("david",22),"david");
        persons.put(new Person("tom",23),"tom");
        persons.put(new Person("jerry",24),"jerry");
        String james = persons.put(new Person("jerry", 24), "james");//key重复，会返回原有的value
        System.out.println(james);
        System.out.println(persons);
        Set<Map.Entry<Person, String>> entries = persons.entrySet();
        for (Map.Entry<Person, String> entry : entries) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }

    /**
    HashMap存储自定义类型键值
    Map集合保证key是唯一的:
        作为key的元素,必须重写hashCode方法和equals方法,以保证key唯一

     HashMap存储自定义类型键值
     key:String类型
     String类重写hashCode方法和equals方法,可以保证key唯一
     value:Person类型
     value可以重复(同名同年龄的人视为同一个)
    */
    private static void hashMapSavePerson() {
        Map<String,Person> persons=new HashMap<>();
        persons.put("david",new Person("david",22));
        persons.put("tom",new Person("tom",23));
        persons.put("jerry",new Person("jerry",24));
        System.out.println(persons);

        Set<String> keySet = persons.keySet();
        for (String s : keySet) {
            Person person = persons.get(s);
            System.out.println(person);
        }
    }

    /**
    Map集合遍历的第二种方式:使用Entry对象遍历

    Map集合中的方法:
        Set<Map.Entry<K,V>> entrySet() 返回此映射中包含的映射关系的 Set 视图。

    实现步骤:
        1.使用Map集合中的方法entrySet(),把Map集合中多个Entry对象取出来,存储到一个Set集合中
        2.遍历Set集合,获取每一个Entry对象
        3.使用Entry对象中的方法getKey()和getValue()获取键与值
    */
    private static void entrySetMethod() {
        Map<String,String> map=new HashMap<>();
        map.put("a","a");
        map.put("b","a");
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println("使用迭代器遍历entries");
        Iterator<Map.Entry<String, String>> it = entries.iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:"+key+",vale:"+value);
        }
        System.out.println("增强for遍历entrys");
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key:"+entry.getKey()+",vale:"+entry.getValue());
        }
    }

    /**
    Map集合的第一种遍历方式:通过键找值的方式
    Map集合中的方法:
         Set<K> keySet() 返回此映射中包含的键的 Set 视图。
    实现步骤:
        1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一个Set集合中
        2.遍历set集合,获取Map集合中的每一个key
        3.通过Map集合中的方法get(key),通过key找到value
    */
    private static void keySetMethod() {
        Map<String,String> map=new HashMap<>();
        map.put("a","a");
        map.put("b","a");
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");
        System.out.println("使用迭代器遍历keys");
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            String value = map.get(key);
            System.out.println(value);
        }
        System.out.println("使用增强for循环的方式遍历keyset");
        for (String key : keys) {
            System.out.println(map.get(key));
        }
    }

    /**
        boolean containsKey(Object key) 判断集合中是否包含指定的键。
        包含返回true,不包含返回false
     */
    private static void containsKeysMethod() {
        Map<String,String> map=new HashMap<>();
        map.put("a","a");
        map.put("b","a");
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");

        boolean b = map.containsKey("a");
        System.out.println(b);//true
        b=map.containsKey("f");
        System.out.println(b);//false
    }

    /**
        public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
            返回值:
                key存在,返回对应的value值
                key不存在,返回null
     */
    private static void getMethod() {
        Map<String,String> map=new HashMap<>();
        map.put("a","a");
        map.put("b","a");
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");

        String a = map.get("a");
        System.out.println(a);

        String f = map.get("f");
        System.out.println(f);//如果key不存在，则返回null
    }

    /**
        public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
            返回值:V
                key存在,v返回被删除的值
                key不存在,v返回null
     */
    private static void removeMethod() {
        Map<String,String> map=new HashMap<>();
        map.put("a","a");
        map.put("b","a");
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");
        //删除之前的map
        System.out.println(map);
        String e = map.remove("e");
        System.out.println(e);
        System.out.println(map);
        e = map.remove("e");
        System.out.println(e);//当key不存在的时候返回null
        System.out.println(map);

    }

    /**
        public V put(K key, V value):  把指定的键与指定的值添加到Map集合中。
            返回值:v
                存储键值对的时候,key不重复,返回值V是null
                存储键值对的时候,key重复,会使用新的value替换map中重复的value,返回被替换的value值
     */
    private static void puthMethod() {
        Map<String,String> map=new HashMap<>();
        String v1 = map.put("name", "david");//null,集合中key不重复无返回值
        System.out.println();
        map.put("age","22");
        String v2 = map.put("name", "david");
        System.out.println(v2);
        System.out.println(map);

        map.put("a","a");
        map.put("b","a");//key不能重复，vaklue可以重复
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");
        System.out.println(map);
    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}




















