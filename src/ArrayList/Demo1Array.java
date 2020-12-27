package com.hs_vae.ArrayList;
//Date:2020.10.11
/*
 * 对象数组
 */
public class Demo1Array {
	public static void main(String[] args) {
		Person[] a=new Person[3];   //创建一个对象数组，并且存储3个对象
		
		//定义3个对像
		Person one=new Person("阿坚",20);
		Person two=new Person("阿福",19);
		Person three=new Person("阿赛",21);
		//将这3个对象的地址值赋值给数组
		a[0]=one;
		a[1]=two;
		a[2]=three;
		
		for(int i=0;i<3;i++) {
			        System.out.println(a[i]);   //打印输出地址值
					System.out.println(a[i].getName()+","+a[i].getAge());  //打印输出三个对象成员变量中的名字和年龄
					
		}
	}

}
