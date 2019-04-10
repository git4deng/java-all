package com.david.api.random;

import java.util.Random;
import java.util.Scanner;

/**
 * @author david
 * @create 2019-04-09 10:33
 */
public class R02RandomGame {
    public static void main(String[] args) {
        int number = new Random().nextInt(100) + 1;
        System.out.println("请输入一个数字（退出请输入-1）：");
        Scanner sc=new Scanner(System.in);
        while (true){
            int i = sc.nextInt();
            if(i==-1){
                break;//输入-1退出
            }else if(i<number){
                System.out.println("太小了，请重试。");
            }else if (i>number){
                System.out.println("太大了，请重试。");
            }else if (i==number){
                System.out.println("恭喜你，猜中啦！");
                break; // 如果猜中，不再重试
            }
        }
        System.out.println("游戏结束！");
    }
}
