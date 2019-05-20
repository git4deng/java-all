package com.david.web.annotation;

import java.lang.annotation.*;

/**
 *  元注解：用于描述注解的注解
 *  @Target：描述注解能够作用的位置
 *      ElementType取值：
 *          TYPE：可以作用于类上
 *          METHOD：可以作用于方法上
 *             FIELD：可以作用于成员变量上
 *  @Retention：描述注解被保留的阶段
 *          @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
 *  @Documented：描述注解是否被抽取到api文档中
 *  @Inherited：描述注解是否被子类继承
 * @author david
 * @create 2019-05-01 21:45
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface A03MetaAnnotation {
}
@A03MetaAnnotation
class testMetaAnnotation{
    //@A03MetaAnnotation 仅仅只能使用在类上
    public void method(){

    }
}