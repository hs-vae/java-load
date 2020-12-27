package com.hs_vae.Demo2;
import java.util.Random;
//Date:2020.10.11       
/*
 * 练习:定义一个随机变量,利用Random获取[1,n]的值
 */
public class Demo8Random1 {
	public static void main(String[] args) {
		int n=5;
		Random a=new Random();
		for(int i=0;i<100;i++) {
					int result=a.nextInt(n)+1;  //方法加1可以实现整体[0,n)区间向后挪一位,变成[1,n]
					System.out.println("在[1,n]区间内随机输出的值是:"+result);
		}
		
	}

}
