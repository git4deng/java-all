package com.david.javase.oop;

/**
 * 练习：
 * 定义一个类，用来模拟“手机”事物。
 属性：品牌、价格、颜色
 行为：打电话、发短信

 对应到类当中：
 成员变量（属性）：
 String brand; // 品牌
 double price; // 价格
 String color; // 颜色
 成员方法（行为）：
 public void call(String who) {} // 打电话
 public void sendMessage() {} // 群发短信
 * @author david
 * @create 2019-04-08 21:16
 */
public class O4ExercisePhone {
    public String brand;
    public double price;
    public String color;
    public void call(String who){
        System.out.println("给"+who+"打电话！");
    }
    public void sendMessage(){
        System.out.println("发送短信息。。。");
    }
}
