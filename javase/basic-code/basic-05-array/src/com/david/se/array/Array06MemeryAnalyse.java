package com.david.se.array;

/**
 数组内存分析
 */
public class Array06MemeryAnalyse {
    public static void main(String[] args) {
        int[] arrI=new int[3];//动态初始化

        System.out.println(arrI);//地址值
        System.out.println(arrI[0]);//初始化的默认值0
        System.out.println(arrI[1]);//初始化的默认值0
        System.out.println(arrI[2]);//初始化的默认值0

        System.out.println("----------------------");
        //改变数组元素的内容
        arrI[1]=10;
        arrI[2]=20;
        System.out.println(arrI[0]);//初始化的默认值0
        System.out.println(arrI[1]);//初始化的默认值0
        System.out.println(arrI[2]);//初始化的默认值0

    }
}
