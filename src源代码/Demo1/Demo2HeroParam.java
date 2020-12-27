package com.hs_vae.Demo1;

//Date:2020.10.8
//Content:使用对象类型作为方法的参数
public class Demo2HeroParam {
public static void main(String[] args) {
	Hero one=new Hero();
	one.Welcome();
	getHero(one);
}
public static void getHero(Hero param) {
	param.name="诺克萨斯之手";
	param.skills="断头台";
	param.grade=6;
	param.equipment="黑切,水银鞋,板甲,兰盾,振奋,石像鬼板甲";
	System.out.println(param.name);
	System.out.println(param.skills);
	System.out.println(param.grade);
	System.out.println(param.equipment);
}

}
