package com.david.api.Extends;

/**
 * 在父子类的继承关系当中，如果成员变量重名，则创建子类对象时，访问有两种方式：

 直接通过子类对象访问成员变量：
 等号左边是谁，就优先用谁，没有则向上找。
 间接通过成员方法访问成员变量：
 该方法属于谁，就优先用谁，没有则向上找。
 * @author david
 * @create 2019-04-11 20:38
 */
public class E02ExtentdsFields {
    public static void main(String[] args) {
        Fu f=new Fu();
        System.out.println(f.num);//100
        System.out.println("----------------");
        Fu f1=new Zi();
        System.out.println(f.num);//100
        f1.methodFu();//100
        System.out.println("----------------");
        Zi z=new Zi();
        System.out.println(z.num);//200
        System.out.println(z.numFu);//10
        System.out.println(z.numZi);//100
        System.out.println("----------------");
        z.methodFu();//100
        z.methodZi();//200,100
    }
}

class Fu{
    int numFu=10;
    int num=100;
    public void methodFu(){
        System.out.println(num);
    }
}
class Zi extends Fu{
    int numZi=100;
    int num=200;
    // 因为本类当中有num，所以这里用的是本类的num
    public void methodZi(){
        System.out.println(num);
        System.out.println(super.num);
    }

}
