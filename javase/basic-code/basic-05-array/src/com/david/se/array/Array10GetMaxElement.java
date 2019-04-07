package com.david.se.array;

/**
 求出数组最大值

 */
public class Array10GetMaxElement {
    public static void main(String[] args) {
        int[] arr={1,3,4,5,7,1,22,11,23,32,55,12,33};
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) max=arr[i];
        }
        System.out.println("最大值："+max);
    }
}
