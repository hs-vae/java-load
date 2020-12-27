package com.hs_vae.Demo2;
//Date:2020.10.10
//Content:利用匿名参数作为方法的参数和返回值
import java.util.Scanner;
public class Demo6Anoymous {
	public static void main(String[] args) {
		int num=new Scanner(System.in).nextInt();
		System.out.println("①输入的是:"+num);
		
		//使用匿名对象进行传参
		methodParam(new Scanner(System.in));
		//使用匿名对象作为返回值
		Scanner b=methodReturn();
		int c=b.nextInt();
		System.out.println("③输入的是:"+c);
	}
	public static void methodParam(Scanner sc) {
		int a=sc.nextInt();
		System.out.println("②输入的是:"+a);
	}
	public static Scanner methodReturn() {
		return new Scanner(System.in);
	}
	

}
