package com.david.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 解析注解
 * @author david
 * @create 2019-05-01 21:50
 */
@MyAnno(className = "com.david.web.annotation.Demo01",methodName = "method")
public class A04ResolveAnnotation {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //1.1获取该类的字节码文件
        Class<A04ResolveAnnotation> arac = A04ResolveAnnotation.class;
        //2获取字节码文件上的注解


        /*
        注意下面这行代码，其实就是在内存中生成了一个该注解接口的实现类的对象,
        其实现的方法返回值就是配置该注解的属性值
         */
        MyAnno myAnno = arac.getAnnotation(MyAnno.class);//获取指定的注解，也可以获取该类所有的注解
        //3 调用注解中定义的抽象方法，获取返回值
        String className = myAnno.className();
        String methodName = myAnno.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //4.使用反射技术，就可以执行该注解配置的类的方法
        Class cls = Class.forName(className);
        Method m = cls.getDeclaredMethod(methodName);
        m.setAccessible(true);

        m.invoke(cls.newInstance());

    }
}

/**
 * 描述需要执行的类名和方法名
 */
@Target({ElementType.TYPE})//作用于类上
@Retention(RetentionPolicy.RUNTIME)//该注解保留到运行期
@interface MyAnno{
    String className();
    String methodName();
}
class Demo01{
    public void method(){
        System.out.println("注解的方式引入反射.......");
    }
}