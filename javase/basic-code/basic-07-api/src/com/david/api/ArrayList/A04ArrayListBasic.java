package com.david.api.ArrayList;

import java.util.ArrayList;

/**
 * ArrayList存储基本类型数据
 * 如果希望向集合ArrayList当中存储基本类型数据，必须使用基本类型对应的“包装类”。

 基本类型    包装类（引用类型，包装类都位于java.lang包下）
 byte        Byte
 short       Short
 int         Integer     【特殊】
 long        Long
 float       Float
 double      Double
 char        Character   【特殊】
 boolean     Boolean

 从JDK 1.5+开始，支持自动装箱、自动拆箱。

 自动装箱：基本类型 --> 包装类型
 自动拆箱：包装类型 --> 基本类型
 * @author david
 * @create 2019-04-09 22:58
 */
public class A04ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        //自动装箱
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        //自动拆箱
        Integer n = list.get(1);

        System.out.println(n);
    }
}
