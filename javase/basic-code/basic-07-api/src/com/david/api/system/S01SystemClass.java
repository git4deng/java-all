package com.david.api.system;

import java.util.Arrays;

/**
 *  java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API文档中，常用的方法有：
    public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
 * @author david
 * @create 2019-04-13 14:14
 */
public class S01SystemClass {
    public static void main(String[] args) {
        
        getCurrentTimeMillis();
        copyArrayMethod();

    }

    /**
     * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
     参数:
     src - 源数组。
     srcPos - 源数组中的起始位置(起始索引)。
     dest - 目标数组。
     destPos - 目标数据中的起始位置。
     length - 要复制的数组元素的数量。
     练习:
     将src数组中前3个元素，复制到dest数组的前3个位置上
     复制元素前：
     src数组元素[1,2,3,4,5]，dest数组元素[6,7,8,9,10]
     复制元素后：
     src数组元素[1,2,3,4,5]，dest数组元素[1,2,3,9,10]
     */
    private static void copyArrayMethod() {
        int[] src={1,2,3,4,5};
        int[] dest={6,7,8,9,10};
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(dest));
        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(dest));
    }

    private static void getCurrentTimeMillis() {
        System.out.println(System.currentTimeMillis());
        long t1 = System.currentTimeMillis();
        System.out.println("程序开始时间："+t1);
        for (int i = 0; i < 9999; i++) {
            System.out.println("输出："+i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("程序结束时间："+t2);

        System.out.println("运行时间："+((t2-t1))+"毫秒！");
    }
}
