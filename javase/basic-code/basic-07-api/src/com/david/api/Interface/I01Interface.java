package com.david.api.Interface;

/**
 * 接口就是多个类的公共规范。
 接口是一种引用数据类型，最重要的内容就是其中的：抽象方法。

 如何定义一个接口的格式：
 public interface 接口名称 {
 // 接口内容
 }

 备注：换成了关键字interface之后，编译生成的字节码文件仍然是：.java --> .class。

 如果是Java 7，那么接口中可以包含的内容有：
 1. 常量
 2. 抽象方法

 如果是Java 8，还可以额外包含有：
 3. 默认方法
 4. 静态方法

 如果是Java 9，还可以额外包含有：
 5. 私有方法

 接口使用步骤：
 1. 接口不能直接使用，必须有一个“实现类”来“实现”该接口。
 格式：
 public class 实现类名称 implements 接口名称 {
 // ...
 }
 2. 接口的实现类必须覆盖重写（实现）接口中所有的抽象方法。
 实现：去掉abstract关键字，加上方法体大括号。
 3. 创建实现类的对象，进行使用。

 注意事项：
 如果实现类并没有覆盖重写接口中所有的抽象方法，那么这个实现类自己就必须是抽象类。
 * @author david
 * @create 2019-04-11 23:27
 */
public class I01Interface {
    public static void main(String[] args) {
        MyInterfaceAbstract mia=new MyInterfaceAbstractImpl();
        mia.methodAbs1();
        mia.methodAbs2();
        mia.methodAbs3();
        mia.methodAbs4();
    }
}

/**
 * 在任何版本的Java中，接口都能定义抽象方法。
 格式：
 public abstract 返回值类型 方法名称(参数列表);

 注意事项：
 1. 接口当中的抽象方法，修饰符必须是两个固定的关键字：public abstract
 2. 这两个关键字修饰符，可以选择性地省略。（今天刚学，所以不推荐。）
 3. 方法的三要素，可以随意定义。
 */
interface MyInterfaceAbstract{
    public abstract void methodAbs1();
    // 这也是抽象方法
    abstract void methodAbs2();

    // 这也是抽象方法
    public void methodAbs3();

    // 这也是抽象方法
    void methodAbs4();
}
class MyInterfaceAbstractImpl implements MyInterfaceAbstract{

    @Override
    public void methodAbs1() {
        System.out.println("这是第一个方法");
    }

    @Override
    public void methodAbs2() {
        System.out.println("这是第二个方法");
    }

    @Override
    public void methodAbs3() {
        System.out.println("这是第三个方法");
    }

    @Override
    public void methodAbs4() {
        System.out.println("这是第四个方法");
    }
}