package com.hs_vae.Demo1;

//Date:2020.10.6
//Content:对象的创建以及使用。
public class Demo1Hero {
	public static void main(String[] args) {
		   Hero a=new Hero();   //定义一个名叫a的英雄类
		   //打印输出a的英雄类属性默认值
           System.out.println(a.grade);    //int类型默认值是0
           System.out.println(a.name);     //String类型默认值是null
           System.out.println(a.skills);   //String类型默认值是null
           //给对象a的属性进行赋值
           a.grade=6;
           a.Summoner="阿坚";
           a.name="墨菲特";
           a.skills="势不可挡";
           a.equipment="日炎,冰拳,水银鞋,振奋,适应性头盔,兰盾";
           a.rank="白银";
           
      //打印输出对象a的各种属性
       System.out.println("英雄等级:"+a.grade);
       System.out.println("召唤师:"+a.Summoner);
       System.out.println("段位:"+a.rank);
       System.out.println("招牌英雄的名字:"+a.name);
       System.out.println("该英雄的技能:"+a.skills);
       System.out.println("英雄六神装:"+a.equipment);
       
       System.out.println("--------------------");
     
       //调用对象a的方法
       a.Welcome();
       a.backHome();
       a.death();
       a.kill();
}
}