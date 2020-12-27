package com.hs_vae.Demo1;

//Date:2020.10.8
//Content:使用对象类型作为方法返回值类型
public class Demo3HeroReturn {
   public static void main(String[] args) {
	Hero two=getHero();
	System.out.println(two.name);
	System.out.println(two.skills);
	System.out.println(two.equipment);
}
public static Hero getHero() {
	Hero one=new Hero();
	one.name="薇恩猎手";
	one.skills="终极时刻";
	one.equipment="破败，攻速鞋，兰顿，羊刀，无尽，火炮";
	return one;
}
}
