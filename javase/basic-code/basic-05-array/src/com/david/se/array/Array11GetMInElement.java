package com.david.se.array;

/**
 求出数组最大值

 */
public class Array11GetMInElement {
    public static void main(String[] args) {
        int[] arr={21,3,4,5,7,1,22,11,23,32,-55,12,33};
        int min=arr[0];//假设第一个元素是最小的
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min) min=arr[i];
        }
        System.out.println("最小值："+min);
    }
}
