package com.david.se.array;

/**
 一个方法可以有0、1、多个参数；但是只能有0或者1个返回值，不能有多个返回值。
 如果希望一个方法当中产生了多个结果数据进行返回，怎么办？
 解决方案：使用一个数组作为返回值类型即可。

 任何数据类型都能作为方法的参数类型，或者返回值类型。

 数组作为方法的参数，传递进去的其实是数组的地址值。
 数组作为方法的返回值，返回的其实也是数组的地址值。

 */
public class Array14UseAsReturn {
    public static void main(String[] args) {
        int[] result = calculate(1, 2, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] calculate(int a,int b,int c){
        int sum=a+b+c;
        int avg=sum/3;
        int[] arr=new int[2];
        arr[0]=sum;
        arr[1]=avg;
        return arr;
    }


}
