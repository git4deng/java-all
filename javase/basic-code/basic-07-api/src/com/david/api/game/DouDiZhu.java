package com.david.api.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author david
 * @create 2019-04-14 13:50
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //准备扑克
        List<String> poker = createPoker();

        /*
            洗牌：使用集合的工具类 Collections.shuffle
         */
        Collections.shuffle(poker);
        System.out.println(poker);

        /*
        定义4个集合,存储玩家的牌和底牌
         */
        List<String> p1=new ArrayList<>();
        List<String> p2=new ArrayList<>();
        List<String> p3=new ArrayList<>();
        List<String> dipai=new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            if(i>50){
                //最后三张存底牌
                dipai.add(poker.get(i));
            }else if(i%3==0){
                //给第一个玩家
                p1.add(poker.get(i));
            }else if(i%3==1){
                //第二个玩家
                p2.add(poker.get(i));
            }else if(i%3==2){
                //第三个玩家
                p3.add(poker.get(i));
            }
        }
        System.out.println(dipai);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

    }

    private static List<String> createPoker() {
        //准备牌
        List<String> poker=new ArrayList<>();
        //花色
        String [] colors={"♠","♥","♣","♦"};
        //牌序号
        String[] numbers={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for (String color : colors) {
            for (String number : numbers) {
               // System.out.println(color+number);
                poker.add(color+number);
            }
        }
        //大王和小王
        poker.add("大王");
        poker.add("小王");
        System.out.println(poker);
        return poker;
    }
}
