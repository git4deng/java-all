package com.david.javase.oop;

import java.util.Arrays;

/**
 *  面向过程：当需要实现一个功能的时候，每一个具体的步骤都要亲力亲为，详细处理每一个细节。
    面向对象：当需要实现一个功能的时候，不关心具体的步骤，而是找一个已经具有该功能的人，来帮我做事儿。
 * @author david
 * @create 2019-04-08 20:19
 */
public class O01PrintArray {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};
       //使用面向过程的方式实现
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1){
                System.out.println(arr[i]+"]");
            }else{
                System.out.print(arr[i]+",");
            }
        }
        System.out.println("--------------------------------");

        //使用面向对象的方式实现
        System.out.println(Arrays.toString(arr));
    }
}
