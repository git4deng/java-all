package com.david.api.MathUtils;

/**
 * 计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？
 * @author david
 * @create 2019-04-11 0:14
 */
public class M02MathPractise {
    public static void main(String[] args) {
        int counter=0;
        double max=5.9;
        double min=-10.8;
        for (int i=(int)min;i<max;i++){
            int abs=Math.abs(i);
            if(abs>6 || abs<2.1){
                System.out.println(i);
                counter++;
            }
        }
        System.out.println("counter:"+counter);
    }
}
