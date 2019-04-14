package com.david.api.collections.generic01;

import java.util.Date;

/**
 * @author david
 * @create 2019-04-13 23:38
 */
public class G03GenericMethod {
    public static void main(String[] args) {
        GenericMethod gm=new GenericMethod();
        /*
            useGeneric传递什么类型,泛型就是什么类型
         */
        gm.useGeneric(1);
        gm.useGeneric("asd");
        gm.useGeneric(true);

        gm.staticUseGeneric("静态方法,不建议创建对象使用");

        GenericMethod.staticUseGeneric(1);
        GenericMethod.staticUseGeneric("dasda");
        GenericMethod.staticUseGeneric(new Date());

        gm.useGeneric(Integer.class,1);
    }
}

/**
 * 定义含有泛型的方法:泛型定义在方法的修饰符和返回值类型之间

 格式:
 修饰符 <泛型> 返回值类型 方法名(参数列表(使用泛型)){
 方法体;
 }

 含有泛型的方法,在调用方法的时候确定泛型的数据类型
 传递什么类型的参数,泛型就是什么类型
 */
class GenericMethod{
    //定义一个含有泛型的方法
    public <M> void useGeneric(M m){
        System.out.println(m);
    }
    //定义一个含有泛型的静态方法
    public static <S> void staticUseGeneric(S s){
        System.out.println(s);
    }
    public <M> void useGeneric(Class c,M m){
        System.out.println(m.getClass()==c);
    }
}