package com.david.jdk8new.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author david
 * @create 2019-04-25 23:49
 */
public class L04LambdaCompareInterface {
    public static Comparator<String> getComparator(){
        //匿名内部类的方式
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        };
        //lambda表达式的方式返回
       // return (String o1,String o2)->{return o1.length()-o2.length();};
        //lambda简写版本
        return (o1,o2)-> o1.length()-o2.length();
    }

    public static void main(String[] args) {
        String[] arr={"abc","aaaaa","aaaaaaaa","a"};
        System.out.println("排序之前："+ Arrays.toString(arr));
        Arrays.sort(arr,getComparator());
        System.out.println("排序之后："+ Arrays.toString(arr));
    }
}
