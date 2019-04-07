package com.david.se.array;

/**
 数组可以作为方法的参数。
 当调用方法的时候，向方法的小括号进行传参，传递进去的其实是数组的地址值。

 */
public class Array13UseAsParam {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println("原始数组顺序");
        printArr(arr);
        System.out.println("=======================");

        //验证引用传递
        reverse(arr);

        System.out.println("调整后的数组顺序");
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void reverse(int[] arr){
        for (int min=0,max=arr.length-1;min<max;min++,max--){
            int temp=arr[min];
            arr[min]=arr[max];
            arr[max]=temp;
        }
    }
}
