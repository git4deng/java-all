package com.david.api.multi;

/**
 * 代码当中体现多态性，其实就是一句话：父类引用指向子类对象。
 格式：
 父类名称 对象名 = new 子类名称();
 或者：
 接口名称 对象名 = new 实现类名称();
 * @author david
 * @create 2019-04-12 20:37
 */
public class M01Multi {
    public static void main(String[] args) {
        Fu f=new Zi();
        f.method();//子类方法！
        f.methodFu();//父类特定方法！
    }
}
class Fu{
    public void method(){
        System.out.println("父类方法！");
    }
    public void methodFu(){
        System.out.println("父类特定方法！");
    }
}
class Zi extends Fu{
    @Override
    public void method() {
        System.out.println("子类方法！");
    }
}