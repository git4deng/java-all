package com.david.basic.exception;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * java.lang.Throwable:类是 Java 语言中所有错误或异常的超类。
 Exception:编译期异常,进行编译(写代码)java程序出现的问题
 RuntimeException:运行期异常,java程序运行过程中出现的问题
 异常就相当于程序得了一个小毛病(感冒,发烧),把异常处理掉,程序可以继续执行(吃点药,继续革命工作)
 Error:错误
 错误就相当于程序得了一个无法治愈的毛病(非典,艾滋).必须修改源代码,程序才能继续执行
 * @author david
 * @create 2019-04-16 20:55
 */
public class E01Exception {
    public static void main(String[] args) /*throws ParseException*/ {
        //Exception:编译期异常,进行编译(写代码)java程序出现的问题
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//用来格式化日期
        Date date = null;
        try {
            date = sdf.parse("1999-0909");//把字符串格式的日期,解析为Date格式的日期
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);*/

        //RuntimeException:运行期异常,java程序运行过程中出现的问题
        /*int[] arr = {1,2,3};
        //System.out.println(arr[0]);
        try {
            //可能会出现异常的代码
            System.out.println(arr[3]);
        }catch(Exception e){
            //异常的处理逻辑
            System.out.println(e);
        }*/

        /*
            Error:错误
            OutOfMemoryError: Java heap space
            内存溢出的错误,创建的数组太大了,超出了给JVM分配的内存
         */
        //int[] arr = new int[1024*1024*1024];
        //必须修改代码,创建的数组小一点
        int[] arr = new int[1024*1024];
        System.out.println("后续代码");
        throwKeyWords();

        method(null);

    }

    /**
     * throw关键字
     作用:
     可以使用throw关键字在指定的方法中抛出指定的异常
     使用格式:
     throw new xxxException("异常产生的原因");
     注意:
     1.throw关键字必须写在方法的内部
     2.throw关键字后边new的对象必须是Exception或者Exception的子类对象
     3.throw关键字抛出指定的异常对象,我们就必须处理这个异常对象
     throw关键字后边创建的是RuntimeException或者是 RuntimeException的子类对象,我们可以不处理,默认交给JVM处理(打印异常对象,中断程序)
     throw关键字后边创建的是编译异常(写代码的时候报错),我们就必须处理这个异常,要么throws,要么try...catch
     */
    private static void throwKeyWords() {
        //int[] arr = null;
        int[] arr = new int[3];
        int e = getElement(arr,2);
        System.out.println(e);
    }
    /**
        定义一个方法,获取数组指定索引处的元素
        参数:
            int[] arr
            int index
        以后(工作中)我们首先必须对方法传递过来的参数进行合法性校验
        如果参数不合法,那么我们就必须使用抛出异常的方式,告知方法的调用者,传递的参数有问题
        注意:
            NullPointerException是一个运行期异常,我们不用处理,默认交给JVM处理
            ArrayIndexOutOfBoundsException是一个运行期异常,我们不用处理,默认交给JVM处理
     */
    public static int getElement(int[] arr,int index){
        /*
            我们可以对传递过来的参数数组,进行合法性校验
            如果数组arr的值是null
            那么我们就抛出空指针异常,告知方法的调用者"传递的数组的值是null"
         */
        if(arr == null){
            throw new NullPointerException("传递的数组的值是null");
        }

        /*
            我们可以对传递过来的参数index进行合法性校验
            如果index的范围不在数组的索引范围内
            那么我们就抛出数组索引越界异常,告知方法的调用者"传递的索引超出了数组的使用范围"
         */
        if(index<0 || index>arr.length-1){
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组的使用范围");
        }

        int ele = arr[index];
        return ele;
    }
    public static void method(Object obj){
        //对传递过来的参数进行合法性判断,判断是否为null
        /*if(obj == null){
            throw new NullPointerException("传递的对象的值是null");
        }*/

        //Objects.requireNonNull(obj);
        Objects.requireNonNull(obj,"传递的对象的值是null");
    }
}
