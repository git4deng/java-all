package com.david.dataStructure.Set;

/**
 * 哈希值:是一个十进制的整数,由系统随机给出(就是对象的地址值,是一个逻辑地址,是模拟出来得到地址,不是数据实际存储的物理地址)
 在Object类有一个方法,可以获取对象的哈希值
 int hashCode() 返回该对象的哈希码值。
 hashCode方法的源码:
 public native int hashCode();
 native:代表该方法调用的是本地操作系统的方法
 * @author david
 * @create 2019-04-14 21:47
 */
public class S02HashCode {
    public static void main(String[] args) {
        Person p1=new Person();
        System.out.println(p1.hashCode());
        Person p2=new Person();
        System.out.println(p2.hashCode());
        /*
            toString方法的源码:
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
         */
        System.out.println(p1);
        System.out.println(p2);

        /*
            String类的哈希值
                String类重写Obejct类的hashCode方法
         */
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354

        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395
    }
}
class Person{
    //重写hashCode方法

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}