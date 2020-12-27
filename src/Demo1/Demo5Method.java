package com.hs_vae.Demo1;
/*
 封装在Java的体现:
 1.方法就是一种封装
 2.关键字private也是一种封装
 封装就是将一些细节信息隐藏起来，对外不可见
 */
public class Demo5Method {
public static void main(String[] args) {
	int[] array= {1,2,5,10,100,55};
	int max=getMax(array);    //不管你方法用什么循环类型比如while等等，都不影响返回值的结果
	System.out.println("最大值是:"+max);
}

//利用方法，给一个数组，找出最大值并且返回。 
public static int getMax(int[] array) {
	int max=array[0];
	for(int i=0;i<array.length;i++) {
		if(array[i]>max) {
			max=array[i];
		}
	}
	return max;
}
}
