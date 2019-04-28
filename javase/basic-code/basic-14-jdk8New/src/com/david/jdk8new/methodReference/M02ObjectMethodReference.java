package com.david.jdk8new.methodReference;

/**
 * 通过对象名引用成员方法
    使用前提是对象名是已经存在的,成员方法也是已经存在
    就可以使用对象名来引用成员方法
 * @author david
 * @create 2019-04-27 22:36
 */
public class M02ObjectMethodReference {
    public static void main(String[] args) {
       // lambda方式
        printString(s->new MethodReferenceObject().printUpperCaseString(s));

        //方法引用的方式
        /*
            使用方法引用优化Lambda
            对象是已经存在的MethodRerObject
            成员方法也是已经存在的printUpperCaseString
            所以我们可以使用对象名引用成员方法
         */
        printString(new MethodReferenceObject()::printUpperCaseString);

    }
    public  static void printString(Printable2 p){
        p.print("hello");
    }
}
class MethodReferenceObject{
    public void printUpperCaseString(String s){
        System.out.println(s.toUpperCase());
    }
}
/**
 *  定义一个打印的函数式接口
 */
@FunctionalInterface
interface Printable2{
    //定义字符串的抽象方法
    void print(String s);
}
