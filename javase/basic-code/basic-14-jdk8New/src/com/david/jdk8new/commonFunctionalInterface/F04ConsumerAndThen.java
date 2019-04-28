package com.david.jdk8new.commonFunctionalInterface;

import java.util.function.Consumer;

/**
 * Consumer接口的默认方法andThen
 作用:需要两个Consumer接口,可以把两个Consumer接口组合到一起,在对数据进行消费

 例如:
 Consumer<String> con1
 Consumer<String> con2
 String s = "hello";
 con1.accept(s);
 con2.accept(s);
 连接两个Consumer接口  再进行消费
 con1.andThen(con2).accept(s); 谁写前边谁先消费
 * @author david
 * @create 2019-04-26 22:49
 */
public class F04ConsumerAndThen {
    public static void showAndThenMethod(String s, Consumer<String> con1,Consumer<String> con2){

        con1.accept(s);
        con2.accept(s);

        con2.andThen(con1).accept(s);
    }

    public static void main(String[] args) {
        showAndThenMethod("david",(t)->{
            System.out.println(t.toUpperCase());
        },(t)->{
            System.out.println(t.toLowerCase());
        });
    }
}
