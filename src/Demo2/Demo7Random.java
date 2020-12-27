package com.hs_vae.Demo2;
//Date:2020.10.11
/*
 * Random类作用:定义一个变量n,可以随机生成一个[0,n)的数
 */
import java.util.Random;
public class Demo7Random {
public static void main(String[] args) {
	Random a=new Random();
	int num =a.nextInt(2);
	System.out.println("随机生成的一个数为:");
	System.out.println(num);
	
}
}
