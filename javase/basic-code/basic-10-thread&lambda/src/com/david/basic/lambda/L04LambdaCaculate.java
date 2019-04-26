package com.david.basic.lambda;

/**
 * Lambda表达式有参数有返回值的练习
 需求:
 给定一个计算器Calculator接口，内含抽象方法calc可以将两个int数字相加得到和值
 使用Lambda的标准格式调用invokeCalc方法，完成120和130的相加计算
 * @author david
 * @create 2019-04-20 14:12
 */
public class L04LambdaCaculate {
    public static void main(String[] args) {
        int sum = calcu(1, 2, (int a, int b) -> {
            return a + b;
        });
        System.out.println(sum);
         /*
        Lambda表达式:是可推导,可以省略
        凡是根据上下文推导出来的内容,都可以省略书写
        可以省略的内容:
            1.(参数列表):括号中参数列表的数据类型,可以省略不写
            2.(参数列表):括号中的参数如果只有一个,那么类型和()都可以省略
            3.{一些代码}:如果{}中的代码只有一行,无论是否有返回值,都可以省略({},return,分号)
                注意:要省略{},return,分号必须一起省略
         */
        //lambda省略书写格式
       sum = calcu(1, 2, (a,b) -> a +b);
        System.out.println(sum);
    }

    private static int calcu(int i, int i1,Calculator cal) {

        return cal.calculate(i,i1);
    }
}
interface Calculator{
    int calculate(int a,int b);
}