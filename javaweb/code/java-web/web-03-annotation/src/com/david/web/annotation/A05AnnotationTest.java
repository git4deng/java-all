package com.david.web.annotation;

import com.sun.javafx.iio.ios.IosDescriptor;

import javax.xml.bind.Element;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * 注解测试
 * @author david
 * @create 2019-05-01 22:16
 */
public class A05AnnotationTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        Calculator c=new Calculator();
        Class cls = c.getClass();
        //获取所有的方法
        Method[] methods = cls.getMethods();
        //获取对象
        Object o = cls.newInstance();
        //创建字符缓冲输出流
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
        //异常计数器
        int number=0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)){
                try {
                    Object invoke = method.invoke(o);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    number++;
                    bw.write(method.getName()+"出现异常了");
                    bw.newLine();
                    bw.write("异常类型："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因："+e.getCause().getMessage());
                    bw.newLine();

                    bw.write("--------------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现 "+number+" 次异常");

        bw.flush();
        bw.close();
    }
}

/**
 * 测试的类
 */
class Calculator{
    @Check
    public void add(){
        String str=null;
        str.toLowerCase();
        System.out.println("(1+0)="+(1+0));
    }
    @Check
    public void sub(){
        System.out.println("(1-0)="+(1-0));
    }
    @Check
    public void mul(){
        System.out.println("(1*0)="+(1*0));
    }
    @Check
    public void div(){
        System.out.println("(1/0)="+(1/0));
    }
    @Check
    public void show(){
        System.out.println("祖师爷保佑，永无bug......");
    }
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Check{

}