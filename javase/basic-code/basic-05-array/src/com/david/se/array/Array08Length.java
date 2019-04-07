package com.david.se.array;

/**
 如何获取数组的长度，格式：
 数组名称.length

 这将会得到一个int数字，代表数组的长度。

 数组一旦创建，程序运行期间，长度不可改变

 */
public class Array08Length {
    public static void main(String[] args) {
        int[] arrA=new int[5];
        int[] arrB={1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("数组arrB的长度是："+arrB.length);
        System.out.println("--------------------------------");
        int[] arrC=new int[3];
        System.out.println("数组arrB的长度是："+arrC.length);
        arrC=new int[5];
        System.out.println("数组arrB的长度是："+arrC.length);
    }
}
