package com.david.api.Interface;

/**
 * 注意事项：不能通过接口实现类的对象来调用接口当中的静态方法。
 * 一个类可以实现多个接口，多个接口中也可以出现重复的方法名称，那么通过对象调用就不知道调用的那个接口的静态方法了。
 正确用法：通过接口名称，直接调用其中的静态方法。
 格式：
 接口名称.静态方法名(参数);
 * @author david
 * @create 2019-04-11 23:48
 */
public class I03InterfaceStatic {
    public static void main(String[] args) {
        MyInterfaceStatic.staticMethod();
    }
}
/**
从Java 8开始，接口当中允许定义静态方法。
格式：
public static 返回值类型 方法名称(参数列表) {
    方法体
}
提示：就是将abstract或者default换成static即可，带上方法体。
 */
interface MyInterfaceStatic{
    public static void staticMethod(){
        System.out.println("接口静态方法！");
    }
}
