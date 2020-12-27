package com.hs_vae.Demo1;
//Date:2020.10.8
/*
 private关键字可以将需要保护的成员变量进行修饰.
 要是使用了private修饰，只有本类才可以进行访问，但是超出本类范围不能直接访问了，必须间接访问，可以采用getter,setter方法.
 必须使用setXxx getXxx命名规则.
 setter方法不能有返回值，可以有参数,参数类型和成员变量一致.
 getter方法不能有参数，可以有返回值,返回值类型和成员变量一致.
 */
public class Person {
	String name;
	private int age;
	public void show() {
		System.out.println("我叫:"+name+",年龄:"+age);
	}
	public void setAge(int num) {
		if(num<100&&num>0) {
			age=num;
		}else {
			System.out.println("数据错误!");
		}
	}
	
	public int getAge() {
		return age;
	}

}
