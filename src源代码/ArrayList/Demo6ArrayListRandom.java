package com.hs_vae.ArrayList;
//Date:2020.10.12
/*
 * 练习一:生成6个1到33之间的随机整数，添加到集合，并且遍历集合
 */
import java.util.Random;
import java.util.ArrayList;
public class Demo6ArrayListRandom {
       public static void main(String[] args) {
		Random a=new Random();
		
		ArrayList<Integer>  list=new ArrayList<>();
		for(int i=0;i<6;i++) {
			int[] num=new int[6];
			num[i]=a.nextInt(33)+1;           //num可以生成1到33之间的随机整数
			list.add(num[i]);
		}
		for(int i=0;i<list.size();i++) {      //遍历集合
			System.out.println(list.get(i));			
		}
   }
}
