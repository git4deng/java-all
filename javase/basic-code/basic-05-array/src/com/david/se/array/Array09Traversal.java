package com.david.se.array;

/**
 遍历数组，说的就是对数组当中的每一个元素进行逐一、挨个儿处理。默认的处理方式就是打印输出

 */
public class Array09Traversal {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6};
        //index的方式
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println(arr[5]);

        System.out.println("-------------------------");

        //for循环
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        System.out.println("-------------------------");
        //增强for
        for (int n:arr){
            System.out.println(n);
        }
    }
}
