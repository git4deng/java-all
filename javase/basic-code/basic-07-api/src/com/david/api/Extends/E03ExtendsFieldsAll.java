package com.david.api.Extends;

/**
 * 局部变量：         直接写成员变量名
 本类的成员变量：    this.成员变量名
 父类的成员变量：    super.成员变量名
 * @author david
 * @create 2019-04-11 21:05
 */
public class E03ExtendsFieldsAll {
    public static void main(String[] args) {
        Z z=new Z();
        z.method();
    }
}
class F{
    int num =10;

}
class Z extends F{
    int num=30;
    public void method(){
        int num=20;
        System.out.println(this.num);
        System.out.println(num);
        System.out.println(super.num);
    }
}
