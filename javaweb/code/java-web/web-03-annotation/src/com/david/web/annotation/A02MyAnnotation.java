package com.david.web.annotation;

/**
 * 演示方式，使用javac 编译本类，然后使用javap命令反编译A02MyAnnotation.class
 * 得到结论是 这个注解默认继承 java.lang.annotation.Annotation这个接口
 *public interface A02MyAnnotation extends java.lang.annotation.Annotation {}
 * 所以注解本质上就是一个接口
 *
 *  注解属性的返回值类型有下列取值
 *  基本数据类型
 *  String
 *  枚举
 *  注解
 * 以上类型的数组
 * @author david
 * @create 2019-04-29 22:35
 */
public @interface A02MyAnnotation {
    /**
     * 字符串属性
     * @return
     */
    String stringvalue();

    /**
     * 基本类型属性
     * @return
     */
    int intValue();

    /**
     * 注解属性
     * @return
     */
    MyAnnotation annoValue();

    /**
     * 枚举属性
     * @return
     */
    Enum enumValue();

    /**
     * 默认值得属性，在使用本注解得时候可以不用给该属性指定值，若不指定则取默认值
     * @return
     */
    String defaultVlue() default "default";

    /**
     * 数组属性
     * @return
     */
    int[] arrValue();
}
@interface MyAnnotation{

}
enum Enum{
    E1,E2;
}

/**
 *
 * 自定义注解在不使用元注解的情况下，可以使用在类、方法、成员变量之上
 * 注解使用于类上
 * 测试使用自定义注解，未指定带默认值得属性值
 *
 *  1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
    2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
    3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
 */
@A02MyAnnotation(stringvalue = "test",intValue = 123,annoValue = @MyAnnotation,arrValue = {1,2,3,4},enumValue = Enum.E1)
class testAnnotation{
    /**
     * 注解作用于成员变量之上
     */
    @A02MyAnnotation(stringvalue = "test",intValue = 123,annoValue = @MyAnnotation,arrValue = {1,2,3,4},enumValue = Enum.E1,defaultVlue = "ddddd")
    private int n;

    /**
     * 该注解使用在方法上，指定默认属性值的属性值
     */
    @A02MyAnnotation(stringvalue = "test",intValue = 123,annoValue = @MyAnnotation,arrValue = {1,2,3,4},enumValue = Enum.E1,defaultVlue = "ddddd")
    public void test(){

    }
}