package com.hs_vae.Demo1;

public class Array {
	public static void main(String[] args) {
	   //初始化一个int类型，长度为3的数组
	   //动态初始化
	   int[] array1=new int[3];
	   //静态初始化(标准格式),此时不能写上数组长度
	   int[] array2=new int[] {1,2,3}; 
	   //静态初始化省略格式
	   int[] array3= {1,2,3};   
	   System.out.println(array1);
	   System.out.println(array2[2]);
	   System.out.println(array3[1]);
	   
	      
	}
	
}
