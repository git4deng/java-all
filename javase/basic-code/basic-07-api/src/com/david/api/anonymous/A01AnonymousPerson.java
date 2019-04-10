package com.david.api.anonymous;

/**
 * 创建对象的标准格式：
 类名称 对象名 = new 类名称();

 匿名对象就是只有右边的对象，没有左边的名字和赋值运算符。
 new 类名称();

 注意事项：匿名对象只能使用唯一的一次，下次再用不得不再创建一个新对象。
 使用建议：如果确定有一个对象只需要使用唯一的一次，就可以用匿名对象。
 * @author david
 * @create 2019-04-09 9:57
 */
public class A01AnonymousPerson {
    public static void main(String[] args) {
       //标准格式
        Person p=new Person();
        p.name="david";
        p.showName();
        System.out.println("---------------------");
        //匿名对象(注意以下是2个对象）
        new Person().name="dddd";
        new Person().showName();
    }
}
class Person{
    String name;
    public void showName(){
        System.out.println("my name is "+name);
    }
}