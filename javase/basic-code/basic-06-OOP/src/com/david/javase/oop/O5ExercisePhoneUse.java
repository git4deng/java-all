package com.david.javase.oop;

/**
 * @author david
 * @create 2019-04-08 21:16
 */
public class O5ExercisePhoneUse {
    public static void main(String[] args) {
        O4ExercisePhone phone=new O4ExercisePhone();

        System.out.println(phone.brand);//null
        System.out.println(phone.price);//0.0
        System.out.println(phone.color);//null
        System.out.println("=====================");

        phone.brand="oppo";
        phone.price=2899.99;
        phone.color="土豪金";

        System.out.println(phone.brand);
        System.out.println(phone.price);
        System.out.println(phone.color);
        System.out.println("=====================");

        phone.call("david");
        phone.sendMessage();
    }
}
