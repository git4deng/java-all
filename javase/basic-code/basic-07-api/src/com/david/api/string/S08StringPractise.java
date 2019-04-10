package com.david.api.string;

/**
 * 定义一个方法，把数组{1,2,3}按照指定格式拼接成一个字符串。格式参照如下：[word1#word2#word3]。
 * @author david
 * @create 2019-04-10 22:00
 */
public class S08StringPractise {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        String s = intArrayToString(arr);
        System.out.println(s);
    }
    public static String intArrayToString(int[] arr){
        String s="";
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                s+="[word"+arr[i]+"#";
            }else if(i==arr.length-1){
                s+="word"+arr[i]+"]";
            }else{
                s+="word"+arr[i]+"#";
            }
        }
        return s;
    }
}
