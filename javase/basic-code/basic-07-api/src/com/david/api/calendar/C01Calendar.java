package com.david.api.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar类:日历类
 Calendar类是一个抽象类,里边提供了很多操作日历字段的方法(YEAR、MONTH、DAY_OF_MONTH、HOUR )
 Calendar类无法直接创建对象使用,里边有一个静态方法叫getInstance(),该方法返回了Calendar类的子类对象
 static Calendar getInstance() 使用默认时区和语言环境获得一个日历。


 Calendar类的常用成员方法:
 public int get(int field)：返回给定日历字段的值。
 public void set(int field, int value)：将给定的日历字段设置为给定值。
 public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
 public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
 成员方法的参数:
 int field:日历类的字段,可以使用Calendar类的静态成员变量获取
 public static final int YEAR = 1;	年
 public static final int MONTH = 2;	月
 public static final int DATE = 5;	月中的某一天
 public static final int DAY_OF_MONTH = 5;月中的某一天
 public static final int HOUR = 10; 		时
 public static final int MINUTE = 12; 	分
 public static final int SECOND = 13;	秒
 * @author david
 * @create 2019-04-13 13:44
 */
public class C01Calendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("==========get方法演示=========");
        getMethod();
        System.out.println("==========set方法演示=========");
        setMethod();
        System.out.println("==========add方法演示=========");
        addMethod();
    }
    /**
        public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        把指定的字段增加/减少指定的值
        参数:
            int field:传递指定的日历字段(YEAR,MONTH...)
            int amount:增加/减少指定的值
                正数:增加
                负数:减少
     */
    private static void addMethod() {
        Calendar ca=Calendar.getInstance();
        ca.add(Calendar.MONTH,1);
        System.out.println(ca.get(Calendar.YEAR)+"年"+ca.get(Calendar.MONTH)+"月"+ca.get(Calendar.DAY_OF_MONTH)+"日");
        ca.add(Calendar.DAY_OF_MONTH,-2);
        System.out.println(ca.get(Calendar.YEAR)+"年"+ca.get(Calendar.MONTH)+"月"+ca.get(Calendar.DAY_OF_MONTH)+"日");
    }

    /**
     * public void set(int field, int value)：将给定的日历字段设置为给定值。
     参数:
     int field:传递指定的日历字段(YEAR,MONTH...)
     int value:给指定字段设置的值
     */
    private static void setMethod() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR,2099);
        System.out.println(ca.get(Calendar.YEAR));
        ca.set(Calendar.MONTH,13);//当月数超过了12，年数会相应的增加 设置值/12的值，而月份就是余数
        System.out.println(ca.get(Calendar.YEAR)+","+ca.get(Calendar.MONTH));//

        //也可以一次将年月日直接设置进去
        ca.set(9999,1,1);
        System.out.println(ca.get(Calendar.YEAR)+","+ca.get(Calendar.MONTH)+","+ca.get(Calendar.DAY_OF_MONTH));
    }

    private static void getMethod() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        System.out.println("年："+year);
        System.out.println("月："+(ca.get(Calendar.MONTH)+1));//西方的月份0-11 东方:1-12
        System.out.println("日："+ca.get(Calendar.DAY_OF_MONTH));
        //把日历对象,转换为日期对象
        Date time = ca.getTime();
        System.out.println(time);

    }
}
