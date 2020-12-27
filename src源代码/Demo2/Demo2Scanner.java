package com.hs_vae.Demo2;
//Date:2020.10.10
/*
 Scanner类的功能可以实现键盘输入数据,到程序当中
 一般使用步骤如下:
 1.导包
 import 包路劲.类名称;    //只有java.lang包下的内容不需要导包其他的都要
 2.创建
 类名称 对象名 =new 类名称();
 3.使用
 对面名.成员方法名();
 */
import java.util.Scanner;
public class Demo2Scanner {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//获取整型的Scanner方法为nextInt()
		int num=sc.nextInt();
		System.out.println("输入的数字值是:"+num);
		
		//获取字符串的Scanner方法为next()
		String c=sc.next();
		System.out.println("输入的字符串是:"+c);
		
	}

}
