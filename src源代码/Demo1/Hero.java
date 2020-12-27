package com.hs_vae.Demo1;
//Date:2020.10.6
//Content:定义一个英雄类
public class Hero {
   String name;    //英雄名字
   String skills;  //英雄技能
   int grade;      //英雄等级
   String Summoner;    //召唤师名字
   String equipment;   //英雄装备
   String rank;        //召唤师段位

public void Welcome() {
	System.out.println("欢迎来到英雄联盟,敌军还有30秒到达战场,捏碎它们!!");
}
public void backHome() {
	System.out.println("回城");
}

public void kill() {
	System.out.println("击杀敌方一名英雄");
}

public void death() {
	System.out.println("被敌方英雄击杀");
}
}