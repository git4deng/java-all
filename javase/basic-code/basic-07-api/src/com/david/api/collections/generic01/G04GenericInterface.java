package com.david.api.collections.generic01;

/**
 * @author david
 * @create 2019-04-13 23:48
 */
public class G04GenericInterface {
    public static void main(String[] args) {
        System.out.println("第一种使用方式:定义接口的实现类,实现接口,指定接口的泛型");
        GenericInterfaceImpl gi=new GenericInterfaceImpl();
        gi.method("adasdsada");

        System.out.println("含有泛型的接口第二种使用方式:接口使用什么泛型,实现类就使用什么泛型,类跟着接口走");
        new GenericInterfaceImpl2<String>().method("dasdasd");
        new GenericInterfaceImpl2<Integer>().method(123);
    }

}

/**
 * 定义含有泛型的接口
 * @param <I>
 */
interface GenericInterface<I>{
    void method(I i);
}

/**
 * 含有泛型的接口,第一种使用方式:定义接口的实现类,实现接口,指定接口的泛型
 public interface Iterator<E> {
 E next();
 }
 Scanner类实现了Iterator接口,并指定接口的泛型为String,所以重写的next方法泛型默认就是String
 public final class Scanner implements Iterator<String>{
 public String next() {}
 }
 */
class GenericInterfaceImpl implements GenericInterface<String>{

    @Override
    public void method(String s) {
        System.out.println(s);
    }
}

/**
 * 含有泛型的接口第二种使用方式:接口使用什么泛型,实现类就使用什么泛型,类跟着接口走
 就相当于定义了一个含有泛型的类,创建对象的时候确定泛型的类型
 public interface List<E>{
 boolean add(E e);
 E get(int index);
 }
 public class ArrayList<E> implements List<E>{
 public boolean add(E e) {}
 public E get(int index) {}
 }
 * @param <E>
 */
class GenericInterfaceImpl2<E> implements GenericInterface<E>{

    @Override
    public void method(E e) {

    }
}