package com.david.api.ArrayList;

import java.util.ArrayList;
import java.util.Random;

/**
 * 生成6个1~33之间的随机整数，添加到集合，并遍历集合。
 * @author david
 * @create 2019-04-09 23:07
 */
public class A05ArrayListRandim {
    public static void main(String[] args) {
        ArrayList<Integer> randoms=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i <6; i++) {
            randoms.add(r.nextInt(32)+1);
        }
        System.out.println(randoms);
        System.out.println("------------------");
        for (Integer random : randoms) {
            System.out.println(random);
        }
    }
}
