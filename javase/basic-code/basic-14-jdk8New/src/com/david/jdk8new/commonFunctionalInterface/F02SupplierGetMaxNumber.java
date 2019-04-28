package com.david.jdk8new.commonFunctionalInterface;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * 练习：求数组元素最大值
 使用Supplier接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。
 提示：接口的泛型请使用java.lang.Integer类。
 * @author david
 * @create 2019-04-26 22:20
 */
public class F02SupplierGetMaxNumber {

    public static void main(String[] args) {
        Integer[] arr={1,2,3,0,440,11,232,434};
        Integer maxNumber = getMaxNumber(() -> {
            int max = arr[0];
            for (Integer i : arr) {
                if (i > max) max = i;
            }
            return max;
        });
        System.out.println(Arrays.toString(arr));
        System.out.println("数组中元素的最大值是："+maxNumber);


    }
    public static Integer getMaxNumber(Supplier<Integer> supplier){
        return supplier.get();
    }
}
