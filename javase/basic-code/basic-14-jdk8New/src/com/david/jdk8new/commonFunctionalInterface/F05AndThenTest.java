package com.david.jdk8new.commonFunctionalInterface;

import java.util.function.Consumer;

/**
 * 练习:
 字符串数组当中存有多条信息，请按照格式“姓名：XX。性别：XX。”的格式将信息打印出来。
 要求将打印姓名的动作作为第一个Consumer接口的Lambda实例，
 将打印性别的动作作为第二个Consumer接口的Lambda实例，
 将两个Consumer接口按照顺序“拼接”到一起。
 * @author david
 * @create 2019-04-26 22:56
 */

public class F05AndThenTest {
    public static void printInfo(String[] arr, Consumer<String> c1,Consumer<String> c2){
        for (String s : arr) {
            c1.andThen(c2).accept(s);
        }
    }

    public static void main(String[] args) {
        String[] arr={"david1,11","david2,22","david3,33"};
        printInfo(arr,(s)->{
            String name = s.split(",")[0];
            System.out.print("姓名："+name);
        },(s)->{
            String age = s.split(",")[1];
            System.out.println(",年龄："+age);
        });


    }
}
