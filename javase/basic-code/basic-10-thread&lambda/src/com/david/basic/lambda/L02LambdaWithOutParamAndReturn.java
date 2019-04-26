package com.david.basic.lambda;

/**
 *
 需求:
 给定一个厨子Cook接口，内含唯一的抽象方法makeFood，且无参数、无返回值。
 使用Lambda的标准格式调用invokeCook方法，打印输出“吃饭啦！”字样
 * @author david
 * @create 2019-04-20 13:52
 */
public class L02LambdaWithOutParamAndReturn {
    public static void main(String[] args) {
        //匿名内部类的方式
        new Cook() {
            @Override
            public void makeFood() {
                System.out.println("正在make food ....");
            }
        }.makeFood();

        invokeCook(()->{
            System.out.println("lambda 方式。。。。");
        });

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
        invokeCook(()->System.out.println("lambda 方式。。。。"));
    }

    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
interface Cook{
    void makeFood();
}