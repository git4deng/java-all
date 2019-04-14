package com.david.api.date;

import java.util.Date;

/**
 * @author david
 * @create 2019-04-13 11:41
 */
public class D03DateApi {
    public static void main(String[] args) {
        constructorWithOutFields();
        constructorWithFields();
        dateGetTime();
    }

    /**
     * long getTime() 把日期转换为毫秒值(相当于System.currentTimeMillis()方法)
     返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
     */
    private static void dateGetTime() {
        long time = new Date().getTime();
        System.out.println(time);
    }

    /**
     * Date 的带参构造方法
     */
    private static void constructorWithFields() {
        Date date =new Date(0L);
        System.out.println(date);//Thu Jan 01 08:00:00 CST 1970 东八区
        Date date2 =new Date(1555127290085L);
        System.out.println(date2);//Sat Apr 13 11:48:10 CST 2019
    }

    /**
     * Date的空参数构造方法，获取当前系统的日期和时间
     */
    private static void constructorWithOutFields() {
        Date date=new Date();
        System.out.println(date );
    }
}
