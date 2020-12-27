package com.hs_vae.Demo2;

public class Demo1Student {
	public static void main(String[] args) {
	//有参数方法调用
	Student a=new Student("阿赛",20);
	System.out.println("我是:"+a.getName()+",年龄:"+a.getAge());
	
	//无参数方法调用
	Student b=new Student();
	b.setName("阿坚");
	b.setAge(20);
	System.out.println("我是:"+b.getName()+",年龄:"+b.getAge());
	}
}
