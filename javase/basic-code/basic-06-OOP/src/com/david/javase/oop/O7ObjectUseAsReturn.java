package com.david.javase.oop;

/**
 * 对象作为方法的返回值
 *
 * @author david
 * @create 2019-04-08 21:16
 */
public class O7ObjectUseAsReturn {
    public static void main(String[] args) {
        O4ExercisePhone phone=getPhone();
        System.out.println(phone.brand);
        System.out.println(phone.price);
        System.out.println(phone.color);

        phone.call("david");
        phone.sendMessage();
    }

    public static O4ExercisePhone getPhone() {
        O4ExercisePhone phone = new O4ExercisePhone();
        phone.brand = "苹果";
        phone.price = 8500.00;
        phone.color = "红色";
        return phone;
    }
}
