package com.david.api.collections.generic01;

/**
 * @author david
 * @create 2019-04-13 23:31
 */
public class G02GenericClass {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        GenericClass gc1=new GenericClass<>();
        gc1.setName("只能是字符串");
        String name1 = (String) gc1.getName();
        System.out.println(name1);

        GenericClass<Integer> gc2=new GenericClass<>();
        gc2.setName(12);
        Integer name2 = gc2.getName();
        System.out.println(name2);

        //创建GenericClass对象,泛型使用String类型
        GenericClass<String> gc3 = new GenericClass<>();
        gc3.setName("小明");
        String name3 = gc3.getName();
        System.out.println(name3);

    }
}

/**
 * 定义一个含有泛型的类,模拟ArrayList集合
 泛型是一个未知的数据类型,当我们不确定什么什么数据类型的时候,可以使用泛型
 泛型可以接收任意的数据类型,可以使用Integer,String,Student...
 创建对象的时候确定泛型的数据类型
 */
class GenericClass<E>{
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}