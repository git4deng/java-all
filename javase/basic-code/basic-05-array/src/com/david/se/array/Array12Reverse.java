package com.david.se.array;

/**
 数组反转
 数组元素的反转：
 本来的样子：[1, 2, 3, 4]
 之后的样子：[4, 3, 2, 1]

 要求不能使用新数组，就用原来的唯一一个数组

 */
public class Array12Reverse {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println("原始数组顺序");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("=======================");

        for (int min=0,max=arr.length-1;min<max;min++,max--){
            int temp=arr[min];
            arr[min]=arr[max];
            arr[max]=temp;
        }
        System.out.println("调整后的数组顺序");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
