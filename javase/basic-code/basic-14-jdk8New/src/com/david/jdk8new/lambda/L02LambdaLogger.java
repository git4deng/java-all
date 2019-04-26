package com.david.jdk8new.lambda;

/**
 *  使用Lambda优化日志案例
    Lambda的特点:延迟加载
    Lambda的使用前提,必须存在函数式接口
 * @author david
 * @create 2019-04-25 23:30
 */
public class L02LambdaLogger {
    public static void showLog(int level,MessageBuilder mb){
        //对日志的等级进行判断,如果是1级,则调用MessageBuilder接口中的builderMessage方法
        if(level==1)
            System.out.println(mb.builderMessage());
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";
        /**
            使用Lambda表达式作为参数传递,仅仅是把参数传递到showLog方法中只有满足条件,
            日志的等级是1级才会调用接口MessageBuilder中的方法builderMessage才会进行字符串的拼接
            如果条件不满足,日志的等级不是1级那么MessageBuilder接口中的方法builderMessage也不会执行
            所以拼接字符串的代码也不会执行
            所以不会存在性能的浪费
         */
        showLog(2,()-> {
            System.out.println("不满足条件的时候不执行字符串拼接！");
            return msg1+msg2+msg3;
        });
    }
}

@FunctionalInterface
interface MessageBuilder{
    //定义一个拼接消息的抽象方法,返回被拼接的消息
    public abstract String builderMessage();
}
