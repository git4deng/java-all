package com.david.web.annotation;

/**
 * JDK中预定义的一些注解
 * 		 @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
 * 		 @Deprecated：该注解标注的内容，表示已过时
 * 		 @SuppressWarnings：压制警告
 * @author david
 * @create 2019-04-29 22:30
 */
@SuppressWarnings("all")
public class A01Annotation {
    @Override
    public String toString() {
        return super.toString();
    }
    @Deprecated
    public void show1(){
       //有缺陷，推荐使用新方法
    }
    public void show2(){

    }
    public void demo(){
        show1();
    }
}
