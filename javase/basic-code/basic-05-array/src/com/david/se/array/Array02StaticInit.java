package com.david.se.array;

/**
 * 数组：静态初始化
 *  动态初始化（指定长度）：在创建数组的时候，直接指定数组当中的数据元素个数。
    静态初始化（指定内容）：在创建数组的时候，不直接指定数据个数多少，而是直接将具体的数据内容进行指定。

    静态初始化基本格式：
    数据类型[] 数组名称 = new 数据类型[] { 元素1, 元素2, ... };

    注意事项：
    虽然静态初始化没有直接告诉长度，但是根据大括号里面的元素具体内容，也可以自动推算出来长度。
 */
public class Array02StaticInit {
    public static void main(String[] args) {
        int[] arrI=new int[]{1,2,3,4,5};
        System.out.println("数组长度："+arrI.length);
        String[] arrS=new String[]{"java","sql"};

    }
}
