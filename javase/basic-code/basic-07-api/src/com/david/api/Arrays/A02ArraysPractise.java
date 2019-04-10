package com.david.api.Arrays;

import java.util.Arrays;

/**
 * 请使用Arrays相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印
 * @author david
 * @create 2019-04-11 0:05
 */
public class A02ArraysPractise {
    public static void main(String[] args) {
        String  str="fadbljflksabsfkaj";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}
