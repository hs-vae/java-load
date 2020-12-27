package com.hs_vae.Collection.Test;

import java.util.ArrayList;
import java.util.Collections;

/*
     斗地主综合案例:
        1.准备牌
        2.洗牌
        3.发牌
        4.看牌
 */
public class DouDiZhu {
    public static void main(String[] args) {
        /*
            1.准备牌阶段
         */
        //定义一个存储54张牌的ArrayList集合,泛型使用String
        ArrayList<String> poker = new ArrayList<>();
        //定义两个数组,一个数组存储牌的花色,一个数组存储牌的序号
        String[] colors={"♥","♠","♣","♦"};
        String[] number={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //先将大王和小王存储到poker集合中
        poker.add("大王");
        poker.add("小王");
        //将所有的牌都存储到poker集合中
        for(String Colors:colors){
            for (String Number:number) {
                poker.add(Colors+Number);  //将花色和序号进行组合
            }
        }
        /*
            2.洗牌阶段
         */
        //组合好后,使用工具类Collections中的方法shuffle打乱牌的顺序
        Collections.shuffle(poker);
        /*
            3.发牌阶段
         */
        //建立3个存储玩家牌的集合,在建立存储底牌的集合
        ArrayList<String> playerA = new ArrayList<>();
        ArrayList<String> playerB = new ArrayList<>();
        ArrayList<String> playerC = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();
        for (int i = 0; i < poker.size(); i++) {
            String s = poker.get(i);
            if (i>=51){          //索引值大于等于51时候将发牌给底牌
                diPai.add(s);
            }else if(i%3==0){    //索引值取余数等于0时发牌给玩家A
                playerA.add(s);
            }else if (i%3==1){   //索引值取余数等于1时发牌给玩家B
                playerB.add(s);
            }else if(i%3==2){    //索引值取余数等于2时发牌给玩家C
                playerC.add(s);
            }
        }
        /*
             4.看牌阶段
         */
        //打印输出4个集合
        System.out.println("玩家A:"+playerA);
        System.out.println("玩家B:"+playerB);
        System.out.println("玩家C:"+playerC);
        System.out.println("底牌:"+diPai);
    }
}
