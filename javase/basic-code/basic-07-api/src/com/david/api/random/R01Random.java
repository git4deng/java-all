package com.david.api.random;

import java.util.Random;

/**
 * Random类用来生成随机数字。使用起来也是三个步骤：

 1. 导包
 import java.util.Random;

 2. 创建
 Random r = new Random(); // 小括号当中留空即可

 3. 使用
 获取一个随机的int数字（范围是int所有范围，有正负两种）：int num = r.nextInt()
 获取一个随机的int数字（参数代表了范围，左闭右开区间）：int num = r.nextInt(3)
 实际上代表的含义是：[0,3)，也就是0~2
 * @author david
 * @create 2019-04-09 10:21
 */
public class R01Random {
    public static void main(String[] args) {
        Random r=new Random();
        int n = r.nextInt();
        System.out.println("random number:"+n);

        System.out.println("----------------");
        for (int i = 0; i <100 ; i++) {
            System.out.println(r.nextInt(10));//范围实际上是0~9
        }

        System.out.println("-------------------");
        /*
        根据int变量n的值，来获取随机数字，范围是[1,n]，可以取到1也可以取到n。
         */
        int m=5;
        for (int i = 0; i < 100; i++) {
            // 本来范围是[0,n)，整体+1之后变成了[1,n+1)，也就是[1,n]
            int a = r.nextInt(m) + 1;
            System.out.println(a);
        }
    }
}
