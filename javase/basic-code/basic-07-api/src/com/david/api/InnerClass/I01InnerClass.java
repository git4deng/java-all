package com.david.api.InnerClass;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 如果一个事物的内部包含另一个事物，那么这就是一个类内部包含另一个类。
 例如：身体和心脏的关系。又如：汽车和发动机的关系。

 分类：
 1. 成员内部类
 2. 局部内部类（包含匿名内部类）

 成员内部类的定义格式：
 修饰符 class 外部类名称 {
 修饰符 class 内部类名称 {
 // ...
 }
 // ...
 }

 注意：内用外，随意访问；外用内，需要内部类对象。

 ==========================
 如何使用成员内部类？有两种方式：
 1. 间接方式：在外部类的方法当中，使用内部类；然后main只是调用外部类的方法。
 2. 直接方式，公式：
 类名称 对象名 = new 类名称();
 【外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();】
 * @author david
 * @create 2019-04-12 22:38
 */
public class I01InnerClass {
    public static void main(String[] args) {
        new Body().methodBody(); // 通过外部类的对象，调用外部类的方法，里面间接在使用内部类Heart
        System.out.println("=====================");
        Body.Heart heart= new Body().new Heart();
        heart.beat();
        System.out.println("=====================");
        Outer.Inner in=new Outer().new Inner();
        in.innerMethod();
        //局部内部类
        System.out.println("=====================");
        Outer1 o1=new Outer1();
        o1.method();

    }
}
class Body{
    public class Heart{

        public void beat(){
            System.out.println("内部类方法！");
            System.out.println("直接使用外部类的成员变量："+name);
        }

    }
    private String name;
    public void methodBody(){
        System.out.println("外部类的方法！");
        new Heart().beat();//外部类使用内部类的方法，可以对外提供,即间接的方式
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 如果出现了重名现象，那么格式是：外部类名称.this.外部类成员变量名
 */
class Outer{
    int n=10;//外部类的成员变量

    public class Inner{
        int n=20;//内部类的成员变量

        public void innerMethod(){//内部类的方法
            int n=30;//内部类的局部变量
            System.out.println(n);//内部类局部变量
            System.out.println(this.n);//内部类成员变量
            System.out.println(Outer.this.n);//外部类的成员变量
        }
    }
}

/**
 * 如果一个类是定义在一个方法内部的，那么这就是一个局部内部类。
 “局部”：只有当前所属的方法才能使用它，出了这个方法外面就不能用了。

 定义格式：
 修饰符 class 外部类名称 {
 修饰符 返回值类型 外部类方法名称(参数列表) {
 class 局部内部类名称 {
 // ...
 }
 }
 }

 小节一下类的权限修饰符：
 public > protected > (default) > private
 定义一个类的时候，权限修饰符规则：
 1. 外部类：public / (default)
 2. 成员内部类：public / protected / (default) / private
 3. 局部内部类：什么都不能写
 */
class Outer1{
    public void method(){
        class Inner{//局部内部类
            int n=40;
            public void method(){
                System.out.println(n);
            }
        }
        //局部内部类必须在方法内部使用，除了方法就不能使用了
        new Inner().method();
    }
}

/**
 *
 局部内部类，如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final的】。
 原因是：new出来对象在堆内存中，而局部变量在栈内存中，当方法调用完成，局部变量就直接消失，而可能局部内部类的
 对象还没有被回收，可能导致异常。
 备注：从Java 8+开始，只要局部变量事实不变，那么final关键字可以省略。

 原因：
 1. new出来的对象在堆内存当中。
 2. 局部变量是跟着方法走的，在栈内存当中。
 3. 方法运行结束之后，立刻出栈，局部变量就会立刻消失。
 4. 但是new出来的对象会在堆当中持续存在，直到垃圾回收消失。
 */
class Outer2{
    public void outerMethod(){
        final int num=10;
        class Inner{
            public void method(){
                System.out.println(num);
            }
        }
    }

}