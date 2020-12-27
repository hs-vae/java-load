package com.hs_vae.Demo2;
//Date：2020.10.10
import java.util.Scanner;
public class Demo4ScannerMax {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入第一个值:");
		int a=sc.nextInt();
		System.out.println("请输入第二个值:");
		int b=sc.nextInt();
		System.out.println("请输入第三个值:");
		int c=sc.nextInt();
		int temp=a>b?a:b;          //可以利用三元运算符,a先和b比较得到最大的数字
		int max=temp>c?temp:c;     
		System.out.println("最大值是:"+max);			
		}
	}


