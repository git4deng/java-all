package com.david.javase.oop;

/**
 * 对象作为方法的参数
 * @author david
 * @create 2019-04-08 21:16
 */
public class O6ObjectUseAsParam {
    public static void main(String[] args) {
        O4ExercisePhone phone=new O4ExercisePhone();
        phone.brand="苹果";
        phone.price=8500.00;
        phone.color="红色";
        method(phone);// 传递进去的参数其实就是地址值
    }
    public static void method(O4ExercisePhone param){
        System.out.println(param.brand);
        System.out.println(param.price);
        System.out.println(param.color);

        param.call("david");
        param.sendMessage();
    }
}
