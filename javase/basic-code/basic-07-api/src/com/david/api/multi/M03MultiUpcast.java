package com.david.api.multi;

/**
 * 向上转型一定是安全的，没有问题的，正确的。但是也有一个弊端：
 对象一旦向上转型为父类，那么就无法调用子类原本特有的内容。
 解决方案：用对象的向下转型【还原】。

 如何才能知道一个父类引用的对象，本来是什么子类？
 格式：
 对象 instanceof 类名称
 这将会得到一个boolean值结果，也就是判断前面的对象能不能当做后面类型的实例。
 * @author david
 * @create 2019-04-12 21:01
 */
public class M03MultiUpcast {
    public static void main(String[] args) {
        // 对象的向上转型，就是：父类引用指向之类对象。
        Animal animal=new Cat();
        animal.eat();
//        animal.catchMounse();
        Cat cat= (Cat) animal;
        cat.catchMounse();
     //   Dog dog= (Dog) animal;//java.lang.ClassCastException:类转换异常

        System.out.println("====================================");
        // 如果希望掉用子类特有方法，需要向下转型
        // 判断一下父类引用animal本来是不是Dog
        if(animal instanceof  Dog){
            Dog d=(Dog)animal;
            System.out.println("这是一只狗！");
        }else if (animal instanceof Cat){
            Cat c= (Cat) animal;
            System.out.println("这是一只猫！");
        }
    }
}
abstract class Animal{
    public abstract void eat();
}
class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("猫吃鱼摆摆。。。");
    }
    public void catchMounse(){
        System.out.println("抓老鼠。。。。");
    }
}
class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("gougou chi shit!");
    }
    public void watchHouse(){
        System.out.println("看家门。。。");
    }
}